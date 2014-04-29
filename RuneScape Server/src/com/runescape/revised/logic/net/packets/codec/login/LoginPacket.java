package com.runescape.revised.logic.net.packets.codec.login;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public abstract class LoginPacket extends Packet {

	public LoginPacket(short opcode, VariableType variableType) {
		super(opcode, variableType);
	}
}