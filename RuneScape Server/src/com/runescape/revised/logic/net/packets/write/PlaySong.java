package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class PlaySong extends Packet {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 74;
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
	 * if(pktType == 74)
		{
			int i2 = inStream.method434();
			if(i2 == 65535)
				i2 = -1;
			if(i2 != currentSong && musicEnabled && !lowMem && prevSong == 0)
			{
				nextSong = i2;
				songChanging = true;
				onDemandFetcher.method558(2, nextSong);
			}
			currentSong = i2;
			pktType = -1;
			return true;
		}
	 */
}