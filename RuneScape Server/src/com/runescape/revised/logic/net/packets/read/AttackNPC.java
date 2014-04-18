package com.runescape.revised.logic.net.packets.read;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class AttackNPC extends Packet {

	@Override
	public void executePacket() {
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