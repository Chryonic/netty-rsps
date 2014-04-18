package com.runescape.revised.packets;

import com.runescape.revised.client.GameClient;

public abstract class Packet {

	public abstract void executePacket(GameClient c, int opcode, int packetSize);
	public abstract short getOpcode();
	public abstract byte getSize();
	public abstract VariableType getVariableType();
	
	// public void parsePacket(Client c, ClientFile clientFile, int packetType, int packetSize);
	
	/** private boolean parsePacket()
	{
		if(socketStream == null)
			return false;
		try
		{
			int i = socketStream.available();
			if(i == 0)
				return false;
			if(pktType == -1)
			{
				socketStream.flushInputStream(inStream.buffer, 1);
				pktType = inStream.buffer[0] & 0xff;
				if(encryption != null)
					pktType = pktType - encryption.getNextKey() & 0xff;
				pktSize = SizeConstants.packetSizes[pktType];
				i--;
			}
			if(pktSize == -1)
				if(i > 0)
				{
					socketStream.flushInputStream(inStream.buffer, 1);
					pktSize = inStream.buffer[0] & 0xff;
					i--;
				} else
				{
					return false;
				}
			if(pktSize == -2)
				if(i > 1)
				{
					socketStream.flushInputStream(inStream.buffer, 2);
					inStream.currentOffset = 0;
					pktSize = inStream.readUnsignedWord();
					i -= 2;
				} else
				{
					return false;
				}
			if(i < pktSize)
				return false;
			inStream.currentOffset = 0;
			socketStream.flushInputStream(inStream.buffer, pktSize);
			anInt1009 = 0;
			anInt843 = anInt842;
			anInt842 = anInt841;
			anInt841 = pktType;
			
			
			// packets go here
			
		} catch (Exception exception) {
			
		}
	} */
}