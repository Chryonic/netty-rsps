package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class InterfaceAnimation extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		return 200;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 200)
		{
			int l8 = inStream.readUnsignedWord();
			int i15 = inStream.readSignedWord();
			RSInterface class9_4 = RSInterface.interfaceCache[l8];
			class9_4.anInt257 = i15;
			if(i15 == -1)
			{
				class9_4.anInt246 = 0;
				class9_4.anInt208 = 0;
			}
			pktType = -1;
			return true;
		}
	 */
}