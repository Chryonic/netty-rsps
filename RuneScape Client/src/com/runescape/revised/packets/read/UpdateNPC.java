package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class UpdateNPC extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		// c.updateNPCs(inStream, pktSize);
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 65;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}
	
	/**
	 * updateNPCs(inStream, pktSize);

				pktType = -1;

				return true;


	 */
}
