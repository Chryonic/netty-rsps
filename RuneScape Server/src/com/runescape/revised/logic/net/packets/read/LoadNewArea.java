package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class LoadNewArea extends GamePacket {

	public LoadNewArea() {
		super((byte) -1, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}