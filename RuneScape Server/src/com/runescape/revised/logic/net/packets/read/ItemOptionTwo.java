package com.runescape.revised.logic.net.packets.read;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class ItemOptionTwo extends Packet {

	@Override
	public void executePacket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 16;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}