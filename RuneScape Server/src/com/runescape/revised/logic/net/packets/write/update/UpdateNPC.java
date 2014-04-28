package com.runescape.revised.logic.net.packets.write.update;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class UpdateNPC extends Packet {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		// c.updateNPCs(inStream, pktSize);
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 65;
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
	 * updateNPCs(inStream, pktSize);

				pktType = -1;

				return true;


	 */
}
