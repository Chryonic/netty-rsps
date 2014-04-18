package com.runescape.revised.logic.net.packets.read;

import com.runescape.revised.logic.entity.player.Rank;
import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public abstract class Command extends Packet {
	
	public abstract Rank getRank();
	public abstract String getCommandName();
	public abstract byte getID();

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 103;
	}

	@Override
	public byte getSize() {
		return -1;
	}
	
	@Override
	public VariableType getVariableType() {
		return VariableType.BYTE;
	}
}