package com.runescape.revised.logic.net.packets.write.interfaces;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class InterfaceOffset extends Packet {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 70;
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
	 * if(pktType == 70)
	{
		int k2 = inStream.readSignedWord();
		int l10 = inStream.method437();
		int i16 = inStream.method434();
		RSInterface class9_5 = RSInterface.interfaceCache[i16];
		class9_5.anInt263 = k2;
		class9_5.anInt265 = l10;
		pktType = -1;
		return true;
	}
	 */
}