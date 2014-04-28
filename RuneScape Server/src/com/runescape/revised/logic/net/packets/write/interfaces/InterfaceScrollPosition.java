package com.runescape.revised.logic.net.packets.write.interfaces;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class InterfaceScrollPosition extends Packet {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 79;
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
		if(pktType == 79)
		{
			int j5 = inStream.method434();
			int l12 = inStream.method435();
			RSInterface class9_3 = RSInterface.interfaceCache[j5];
			if(class9_3 != null && class9_3.type == 0)
			{
				if(l12 < 0)
					l12 = 0;
				if(l12 > class9_3.scrollMax - class9_3.height)
					l12 = class9_3.scrollMax - class9_3.height;
				class9_3.scrollPosition = l12;
			}
			pktType = -1;
			return true;
		}
	 */
}