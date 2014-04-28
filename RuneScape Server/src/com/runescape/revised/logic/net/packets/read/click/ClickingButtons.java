package com.runescape.revised.logic.net.packets.read.click;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class ClickingButtons extends GamePacket {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		// writeShort(int)
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 185;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}