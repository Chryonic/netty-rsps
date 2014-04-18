package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class PlaySong extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 74;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * if(pktType == 74)
		{
			int i2 = inStream.method434();
			if(i2 == 65535)
				i2 = -1;
			if(i2 != currentSong && musicEnabled && !lowMem && prevSong == 0)
			{
				nextSong = i2;
				songChanging = true;
				onDemandFetcher.method558(2, nextSong);
			}
			currentSong = i2;
			pktType = -1;
			return true;
		}
	 */
}