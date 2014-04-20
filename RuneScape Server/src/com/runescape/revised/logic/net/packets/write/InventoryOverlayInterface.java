package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class InventoryOverlayInterface extends Packet {

	@Override
	public void executePacket(ChannelBuffer channelBuffer, Channel channel) {
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

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
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