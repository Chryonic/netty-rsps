package com.runescape.revised.packets.write;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;
import com.runescape.revised.packets.VariableType;

public class DropItem extends Packet {

	@Override
	public void executePacket(GameClient c, int opcode, int packetSize) {
		// TODO Auto-generated method stub
		// writeShort(int k) ???
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 87;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}