package com.runescape.revised.logic.net.packets.read.item;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.Priority;
import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class ItemOnItem extends GamePacket {

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
		// TODO Auto-generated method stub
		return 4;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getVariableType()
	 */
	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
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
}