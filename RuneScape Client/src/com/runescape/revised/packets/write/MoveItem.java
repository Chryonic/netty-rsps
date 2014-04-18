package com.runescape.revised.packets.write;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;
import com.runescape.revised.packets.VariableType;

public class MoveItem extends Packet {

	@Override
	public void executePacket(GameClient c, int opcode, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 214;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}