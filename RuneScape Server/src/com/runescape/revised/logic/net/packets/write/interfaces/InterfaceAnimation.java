package com.runescape.revised.logic.net.packets.write.interfaces;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class InterfaceAnimation extends Packet {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		return 200;
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
		if(pktType == 200)
		{
			int l8 = inStream.readUnsignedWord();
			int i15 = inStream.readSignedWord();
			RSInterface class9_4 = RSInterface.interfaceCache[l8];
			class9_4.anInt257 = i15;
			if(i15 == -1)
			{
				class9_4.anInt246 = 0;
				class9_4.anInt208 = 0;
			}
			pktType = -1;
			return true;
		}
	 */
}