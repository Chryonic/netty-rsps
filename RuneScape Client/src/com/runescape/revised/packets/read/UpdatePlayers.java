package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class UpdatePlayers extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// c.updatePlayers(-1, null);
		// aBoolean1080 = false;
		// pktType = -1;
		// return true;
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 81;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}
}