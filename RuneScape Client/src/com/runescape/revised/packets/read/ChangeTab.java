package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class ChangeTab extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 106;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 106)
		{
			tabID = inStream.method427();
			needDrawTabArea = true;
			tabAreaAltered = true;
			pktType = -1;
			return true;
		}
	 */
}
