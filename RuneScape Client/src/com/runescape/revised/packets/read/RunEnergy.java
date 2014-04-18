package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class RunEnergy extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 110;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * if(pktType == 110)
		{
			if(tabID == 12)
				needDrawTabArea = true;
			energy = inStream.readUnsignedByte();
			pktType = -1;
			return true;
		}
	 */
}
