package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class FocusChange extends GamePacket {

	public FocusChange() {
		super((byte) 3, VariableType.FIXED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		// writeShortBigEndian(int)
	}
}