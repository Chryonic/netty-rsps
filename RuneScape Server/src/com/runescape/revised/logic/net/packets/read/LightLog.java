package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class LightLog extends GamePacket {

	public LightLog() {
		super((byte) 79, VariableType.FIXED);
		// TODO Auto-generated constructor stub
	} // 6

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}