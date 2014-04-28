package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class SkillLevel extends Packet {

	@Override
	public void executePacket(Channel channel) {
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

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
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