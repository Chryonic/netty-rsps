package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class EntityAnimationReset extends Packet {

	@Override
	public void executePacket(Channel channel) {
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

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
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