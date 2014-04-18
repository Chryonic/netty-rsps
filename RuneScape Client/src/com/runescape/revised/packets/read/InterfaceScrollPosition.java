package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class InterfaceScrollPosition extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 79;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 79)
		{
			int j5 = inStream.method434();
			int l12 = inStream.method435();
			RSInterface class9_3 = RSInterface.interfaceCache[j5];
			if(class9_3 != null && class9_3.type == 0)
			{
				if(l12 < 0)
					l12 = 0;
				if(l12 > class9_3.scrollMax - class9_3.height)
					l12 = class9_3.scrollMax - class9_3.height;
				class9_3.scrollPosition = l12;
			}
			pktType = -1;
			return true;
		}
	 */
}