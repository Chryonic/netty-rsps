package com.runescape.revised.logic.net.packets.read.buttons;

import com.runescape.revised.logic.entity.player.Rank;
import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

/**
 * Represents a button.
 * 
 * @author Josh
 *
 */
public abstract class Button extends GamePacket {

	/**
	 * The ID for a button.
	 * 
	 * @return id
	 * 			The ID.
	 */
	public abstract int getID();

	/**
	 * The rank needed for a button.
	 * 
	 * @return rank
	 * 			The rank.
	 */
	public abstract Rank getRank();

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getOpcode()
	 */
	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 185;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getSize()
	 */
	@Override
	public byte getSize() {
		return 2;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getVariableType()
	 */
	@Override
	public VariableType getVariableType() {
		return VariableType.FIXED;
	}
}