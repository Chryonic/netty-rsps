package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class TwentyThree extends GamePacket {

	public TwentyThree() {
		super((byte) 23, null);
		// TODO Auto-generated constructor stub
	} // 0

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}