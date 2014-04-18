package com.runescape.revised.logic.net.packets.read;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class CharacterDesignScreen extends Packet {

	@Override
	public void executePacket() {
		// TODO Auto-generated method stub
		// stream.writeWordBigEndian(aBoolean1047 ? 0 : 1);
		// for(int i1 = 0; i1 < 7; i1++)
			// stream.writeWordBigEndian(anIntArray1065[i1]);

		// for(int l1 = 0; l1 < 5; l1++)
			// stream.writeWordBigEndian(anIntArray990[l1]);
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 101;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 13;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}