package com.runescape.revised.packets.write;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;
import com.runescape.revised.packets.VariableType;

public class TypingOnInterface extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 60;
	}

	@Override
	public byte getSize() {
		return 0;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}