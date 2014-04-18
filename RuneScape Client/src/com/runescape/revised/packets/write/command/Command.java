package com.runescape.revised.packets.write.command;

import com.runescape.revised.model.entity.player.Rank;
import com.runescape.revised.packets.Packet;
import com.runescape.revised.packets.VariableType;

public abstract class Command extends Packet {
	
	public abstract Rank getRank();

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