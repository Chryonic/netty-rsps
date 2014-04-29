package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class Follow extends GamePacket {

	public Follow() {
		super((byte) 39, VariableType.FIXED);
		// TODO Auto-generated constructor stub
	} // 2

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}