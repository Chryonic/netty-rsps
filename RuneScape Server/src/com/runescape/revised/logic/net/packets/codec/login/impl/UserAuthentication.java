package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GameDecoder;
import com.runescape.revised.logic.net.packets.codec.login.Login;
import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;
import com.runescape.util.ISAACCipher;
import com.runescape.util.Misc;

public class UserAuthentication extends LoginPacket {

	@Override
	public void executePacket(ChannelBuffer channelBuffer, Channel channel) {
		// TODO Auto-generated method stub
		if (channelBuffer.readableBytes() < 2) {
			return;
		}
		int loginType = channelBuffer.readByte();
		if (loginType != 16 && loginType != 18) {
			System.out.println("Invalid login type: " + loginType);
			//channel.close();
			//return null;
		}
		//System.out.println("Login type = "+loginType);
		int blockLength = channelBuffer.readByte() & 0xff;
		if (channelBuffer.readableBytes() < blockLength) {
			return;
		}
		
		channelBuffer.readByte();
		
		@SuppressWarnings("unused")
		int clientVersion = channelBuffer.readShort();
		/*if (clientVersion != 317) {
			System.out.println("Invalid client version: " + clientVersion);
			channel.close();
			return null;
		}*/
		
		channelBuffer.readByte();
		
		for (int i = 0; i < 9; i++)
			channelBuffer.readInt();
		
		
		channelBuffer.readByte();
		
		int rsaOpcode = channelBuffer.readByte();
		if (rsaOpcode != 10) {
			System.out.println("Unable to decode RSA block properly!");
			channel.close();
			return;
		}
		long clientHalf = channelBuffer.readLong();
		long serverHalf = channelBuffer.readLong();
		int[] isaacSeed = { (int) (clientHalf >> 32), (int) clientHalf, (int) (serverHalf >> 32), (int) serverHalf };
		ISAACCipher inCipher = new ISAACCipher(isaacSeed);
		for (int i = 0; i < isaacSeed.length; i++)
			isaacSeed[i] += 50;
		ISAACCipher outCipher = new ISAACCipher(isaacSeed);
		int version = channelBuffer.readInt();
		String name = Misc.formatPlayerName(Misc.getRS2String(channelBuffer));
		String pass = Misc.getRS2String(channelBuffer);
		channel.getPipeline().replace("decoder", "decoder", new GameDecoder(inCipher));
		new Login(channel, inCipher, outCipher, (short) version, name, pass);
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
	}
}