package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class CloseWindow extends GamePacket {

	public CloseWindow() {
		super((byte) 130, VariableType.FIXED);
		// TODO Auto-generated constructor stub
	} // 0

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
	}
}