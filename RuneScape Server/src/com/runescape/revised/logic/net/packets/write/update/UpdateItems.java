package com.runescape.revised.logic.net.packets.write.update;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.Priority;
import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class UpdateItems extends Packet {

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(final Channel channel) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getOpcode()
	 */
	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 53;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getSize()
	 */
	@Override
	public byte getSize() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getVariableType()
	 */
	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getPriority()
	 */
	@Override
	public Priority getPriority() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
		if(pktType == 53)
		{
			needDrawTabArea = true;
			int i7 = inStream.readUnsignedWord();
			RSInterface class9_1 = RSInterface.interfaceCache[i7];
			int j19 = inStream.readUnsignedWord();
			for(int j22 = 0; j22 < j19; j22++)
			{
				int i25 = inStream.readUnsignedByte();
				if(i25 == 255)
					i25 = inStream.method440();
				class9_1.inv[j22] = inStream.method436();
				class9_1.invStackSizes[j22] = i25;
			}

			for(int j25 = j19; j25 < class9_1.inv.length; j25++)
			{
				class9_1.inv[j25] = 0;
				class9_1.invStackSizes[j25] = 0;
			}

			pktType = -1;
			return true;
		}
	 */
}