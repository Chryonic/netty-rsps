package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

/**
 * The update login packet.
 * 
 * @author Josh
 *
 */
public class Update extends LoginPacket {

	/**
	 * The constructor.
	 */
	public Update() {
		super((byte) 15, null);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}