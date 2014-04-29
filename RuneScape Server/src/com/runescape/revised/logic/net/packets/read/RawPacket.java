package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class RawPacket extends GamePacket {

	public RawPacket() {
		super((byte) -1, null);
		// TODO Auto-generated constructor stub
	} // -1

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}