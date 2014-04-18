package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class UpdateItems extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 53;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 53)
		{
			needDrawTabArea = true;
			int i7 = inStream.readUnsignedWord();
			RSInterface class9_1 = RSInterface.interfaceCache[i7];
			int j19 = inStream.readUnsignedWord();
			for(int j22 = 0; j22 < j19; j22++)
			{
				int i25 = inStream.readUnsignedByte();
				if(i25 == 255)
					i25 = inStream.method440();
				class9_1.inv[j22] = inStream.method436();
				class9_1.invStackSizes[j22] = i25;
			}

			for(int j25 = j19; j25 < class9_1.inv.length; j25++)
			{
				class9_1.inv[j25] = 0;
				class9_1.invStackSizes[j25] = 0;
			}

			pktType = -1;
			return true;
		}
	 */
}