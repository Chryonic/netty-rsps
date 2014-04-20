package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class Sound extends Packet {

	@Override
	public void executePacket(ChannelBuffer channelBuffer, Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 174;
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
		if(pktType == 174)
		{
			int i4 = inStream.readUnsignedWord();
			int l11 = inStream.readUnsignedByte();
			int k17 = inStream.readUnsignedWord();
			if(wave_on && !lowMem && anInt1062 < 50)
			{
				anIntArray1207[anInt1062] = i4;
				anIntArray1241[anInt1062] = l11;
				anIntArray1250[anInt1062] = k17 + Sounds.anIntArray326[i4];
				anInt1062++;
			}
			pktType = -1;
			return true;
		}
	 */
}