package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class InterfaceColor extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 122;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 122)
		{
			int l6 = inStream.method436();
			int i14 = inStream.method436();
			int i19 = i14 >> 10 & 0x1f;
			int i22 = i14 >> 5 & 0x1f;
			int l24 = i14 & 0x1f;
			RSInterface.interfaceCache[l6].textColor = (i19 << 19) + (i22 << 11) + (l24 << 3);
			pktType = -1;
			return true;
		}
	 */
}