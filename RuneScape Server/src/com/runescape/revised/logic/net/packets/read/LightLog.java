package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class LightLog extends GamePacket {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 79;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}