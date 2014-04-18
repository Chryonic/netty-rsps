package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class MinimapState extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
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

	/**
	 * if(pktType == 99)
		{
			anInt1021 = inStream.readUnsignedByte();
			pktType = -1;
			return true;
		}
	 */
}