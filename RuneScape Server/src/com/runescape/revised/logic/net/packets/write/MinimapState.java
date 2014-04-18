package com.runescape.revised.logic.net.packets.write;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class MinimapState extends Packet {

	@Override
	public void executePacket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 99;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * if(pktType == 99)
		{
			anInt1021 = inStream.readUnsignedByte();
			pktType = -1;
			return true;
		}
	 */
}