package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.PacketBuffer;
import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.login.ConnectionType;
import com.runescape.revised.logic.net.packets.codec.login.Login;
import com.runescape.revised.logic.net.packets.codec.login.LoginDecoder;
import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

public class UserAuthentication extends LoginPacket {

	@Override
	public void executePacket(ChannelBuffer channelBuffer, Channel channel) {
		// TODO Auto-generated method stub
		/** System.out.println("Setting up UserAuthentication packet..");
		channelBuffer.readByte();
		System.out.println("Read byte.");
		channelBuffer.readShort();
		System.out.println("Client version is approved");
		channelBuffer.readByte();
		for (int i = 0; i < 9; i++)
			channelBuffer.readInt();
		channelBuffer.readByte();
		channelBuffer.readByte();
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
		channel.getPipeline().replace("decoder", "decoder", new GameDecoder(inCipher)); */
		System.out.println("Now logging in...");
		channel.write(new PacketBuffer().writeByte((byte) 2).writeByte((byte) 0).writeByte((byte) 0));
		new Login(channel/*, (short) version, name, pass*/);
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		if (LoginDecoder.getConnectionType() == ConnectionType.NEW_CONNECTION) {
			return 16;
		}
		return 18;
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