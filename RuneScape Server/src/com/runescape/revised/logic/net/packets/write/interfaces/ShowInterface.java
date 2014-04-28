package com.runescape.revised.logic.net.packets.write.interfaces;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class ShowInterface extends GamePacket {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 97;
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
		if(pktType == 97)
		{
			int l7 = inStream.readUnsignedWord();
			method60(l7);
			if(invOverlayInterfaceID != -1)
			{
				invOverlayInterfaceID = -1;
				needDrawTabArea = true;
				tabAreaAltered = true;
			}
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
			openInterfaceID = l7;
			aBoolean1149 = false;
			pktType = -1;
			return true;
		}
	 */
}
