package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.PacketBuffer;
import com.runescape.revised.logic.net.packets.codec.login.Login;
import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

/**
 * The connect login packet.
 * 
 * @author Josh
 *
 */
public class Connect extends LoginPacket {
	
	/**
	 * The constructor.
	 */
	public Connect() {
		super((byte) 16, null);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(Channel channel) {
		System.out.println("Now logging in...");
		channel.write(new PacketBuffer().writeByte((byte) 2)/**.writeByte((byte) 0).writeByte((byte) 0) */.toPacket());
		new Login(channel/*, (short) version, name, pass*/);
	}
}