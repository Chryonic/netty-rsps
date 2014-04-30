package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.PacketBuffer;
import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GameDecoder;
import com.runescape.revised.logic.net.packets.codec.login.Login;
import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

/**
 * The connect login packet.
 * 
 * @author Josh
 *
 */
public class Connect extends LoginPacket {

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(Channel channel) {
		System.out.println("Now logging in...");
		channel.write(new PacketBuffer().writeByte((byte) 2).writeByte((byte) 0).writeByte((byte) 0));
		new Login(channel/*, (short) version, name, pass*/);
		channel.getPipeline().replace("decoder", "decoder", new GameDecoder(null));
		// player.write(new PacketBuilder(249).putByteA(1).putLEShortA(player.getIndex()).toPacket());
		// player.write(new PacketBuilder(107).toPacket());
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getOpcode()
	 */
	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 16;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getSize()
	 */
	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getVariableType()
	 */
	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
	}
}