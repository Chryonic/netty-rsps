package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class InterfaceOffset extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 70;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}


	/**
	 * if(pktType == 70)
	{
		int k2 = inStream.readSignedWord();
		int l10 = inStream.method437();
		int i16 = inStream.method434();
		RSInterface class9_5 = RSInterface.interfaceCache[i16];
		class9_5.anInt263 = k2;
		class9_5.anInt265 = l10;
		pktType = -1;
		return true;
	}
	 */
}