package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.PacketBuffer;
// import com.runescape.revised.logic.net.packets.codec.login.LoginDecoder;
import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

/**
 * The request login packet.
 * 
 * @author Josh
 *
 */
public class Request extends LoginPacket {
	
	/**
	 * The constructor.
	 */
	public Request() {
		super((byte) 14, null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.buffer.ChannelBuffer, org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(Channel channel) {
		for (byte b = 0; b < 9; b++) {
			channel.write(new PacketBuffer().writeByte((byte) 0).toPacket());
		}
		// LoginDecoder.setConnectionType(ConnectionType.NEW_CONNECTION);
	}
}