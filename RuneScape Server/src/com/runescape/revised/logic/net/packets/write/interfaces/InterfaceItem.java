package com.runescape.revised.logic.net.packets.write.interfaces;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class InterfaceItem extends Packet {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 246;
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
		if(pktType == 246)
		{
			int i6 = inStream.method434();
			int i13 = inStream.readUnsignedWord();
			int k18 = inStream.readUnsignedWord();
			if(k18 == 65535)
			{
				RSInterface.interfaceCache[i6].anInt233 = 0;
				pktType = -1;
				return true;
			} else
			{
				ItemDef itemDef = ItemDef.forID(k18);
				RSInterface.interfaceCache[i6].anInt233 = 4;
				RSInterface.interfaceCache[i6].mediaID = k18;
				RSInterface.interfaceCache[i6].anInt270 = itemDef.modelRotation1;
				RSInterface.interfaceCache[i6].anInt271 = itemDef.modelRotation2;
				RSInterface.interfaceCache[i6].anInt269 = (itemDef.modelZoom * 100) / i13;
				pktType = -1;
				return true;
			}
		}
	 */
}