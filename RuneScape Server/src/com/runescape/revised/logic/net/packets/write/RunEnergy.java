package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class RunEnergy extends Packet {

	@Override
	public void executePacket(ChannelBuffer channelBuffer, Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 110;
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
	 * if(pktType == 110)
		{
			if(tabID == 12)
				needDrawTabArea = true;
			energy = inStream.readUnsignedByte();
			pktType = -1;
			return true;
		}
	 */
}
