package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class EntityAnimationReset extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		return 1;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 1)
		{
			for(int k4 = 0; k4 < playerArray.length; k4++)
				if(playerArray[k4] != null)
					playerArray[k4].anim = -1;

			for(int j12 = 0; j12 < sessionNPCs.length; j12++)
				if(sessionNPCs[j12] != null)
					sessionNPCs[j12].anim = -1;

			pktType = -1;
			return true;
		}
	 */
}