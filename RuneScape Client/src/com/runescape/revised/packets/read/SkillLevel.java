package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class SkillLevel extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 134;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 134)
		{
			needDrawTabArea = true;
			int k1 = inStream.readUnsignedByte();
			int i10 = inStream.method439();
			int l15 = inStream.readUnsignedByte();
			currentExp[k1] = i10;
			currentStats[k1] = l15;
			maxStats[k1] = 1;
			for(int k20 = 0; k20 < 98; k20++)
				if(i10 >= anIntArray1019[k20])
					maxStats[k1] = k20 + 2;

			pktType = -1;
			return true;
		}
	 */
}