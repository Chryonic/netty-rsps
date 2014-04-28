package com.runescape.revised.logic.net.packets.read.npc;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class AttackNPC extends GamePacket {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		// none
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 72;
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