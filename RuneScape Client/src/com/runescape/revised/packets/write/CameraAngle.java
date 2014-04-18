package com.runescape.revised.packets.write;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;
import com.runescape.revised.packets.VariableType;

public class CameraAngle extends Packet {

	@Override
	public void executePacket(GameClient c, int opcode, int packetSize) {
		// TODO Auto-generated method stub
		// writeShort(int)
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 86;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}