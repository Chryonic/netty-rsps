package com.runescape.revised.logic.net.packets.write;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class RegionPosition extends Packet {

	@Override
	public void executePacket() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 85;
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
	 * 
		if(pktType == 85)
		{
			anInt1269 = inStream.method427();
			anInt1268 = inStream.method427();
			pktType = -1;
			return true;
		}
	 */
}
