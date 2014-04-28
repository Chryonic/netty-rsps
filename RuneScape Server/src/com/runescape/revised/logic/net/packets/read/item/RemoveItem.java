package com.runescape.revised.logic.net.packets.read.item;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class RemoveItem extends GamePacket {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
	}
}