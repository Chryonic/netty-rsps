package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class MapWalk extends GamePacket {

	public MapWalk() {
		super((byte) 248, VariableType.BYTE);
		// TODO Auto-generated constructor stub
	} // -1

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}