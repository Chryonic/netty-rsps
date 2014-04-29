package com.runescape.revised.logic.net.packets.codec.game;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public abstract class GamePacket extends Packet {

	public GamePacket(short opcode, VariableType variableType) {
		super(opcode, variableType);
	}
}