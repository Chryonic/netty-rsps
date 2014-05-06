package com.runescape.revised.logic.net.packets.read.command;

import com.runescape.revised.logic.entity.player.Rank;
import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public abstract class Command extends GamePacket {

	public abstract Rank getRank();
	public abstract String getCommandName();
	public abstract byte getID();

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getOpcode()
	 */
	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 103;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getSize()
	 */
	@Override
	public byte getSize() {
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getVariableType()
	 */
	@Override
	public VariableType getVariableType() {
		return VariableType.BYTE;
	}
}