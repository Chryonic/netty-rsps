package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class InventoryOverlayInterface extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 142;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * 
		if(pktType == 142)
		{
			int j6 = inStream.method434();
			method60(j6);
			if(backDialogID != -1)
			{
				backDialogID = -1;
				inputTaken = true;
			}
			if(inputDialogState != 0)
			{
				inputDialogState = 0;
				inputTaken = true;
			}
			invOverlayInterfaceID = j6;
			needDrawTabArea = true;
			tabAreaAltered = true;
			openInterfaceID = -1;
			aBoolean1149 = false;
			pktType = -1;
			return true;
		}
	 */
}