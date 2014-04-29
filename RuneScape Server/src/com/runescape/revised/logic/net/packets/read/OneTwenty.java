package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class OneTwenty extends GamePacket {

	public OneTwenty() {
		super((byte) 120, null);
		// TODO Auto-generated constructor stub
	} // -1

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}