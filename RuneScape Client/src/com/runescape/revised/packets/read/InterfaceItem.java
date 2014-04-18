package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class InterfaceItem extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 246;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 246)
		{
			int i6 = inStream.method434();
			int i13 = inStream.readUnsignedWord();
			int k18 = inStream.readUnsignedWord();
			if(k18 == 65535)
			{
				RSInterface.interfaceCache[i6].anInt233 = 0;
				pktType = -1;
				return true;
			} else
			{
				ItemDef itemDef = ItemDef.forID(k18);
				RSInterface.interfaceCache[i6].anInt233 = 4;
				RSInterface.interfaceCache[i6].mediaID = k18;
				RSInterface.interfaceCache[i6].anInt270 = itemDef.modelRotation1;
				RSInterface.interfaceCache[i6].anInt271 = itemDef.modelRotation2;
				RSInterface.interfaceCache[i6].anInt269 = (itemDef.modelZoom * 100) / i13;
				pktType = -1;
				return true;
			}
		}
	 */
}