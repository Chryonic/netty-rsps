package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.Priority;
import com.runescape.revised.RevisionType;
import com.runescape.revised.logic.net.packets.NettyPacketBuffer;
import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GameDecoder;
import com.runescape.revised.logic.net.packets.codec.login.Login;
import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

/**
 * The connect login packet.
 * 
 * @author Josh
 *
 */
public class Connect extends LoginPacket {

	/**
	 * The revision for the client and server
	 * to connect to.
	 */
	private static RevisionType revisionType;

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(final Channel channel) {
		System.out.println("Now logging in...");
		/** final short revision = (short) channelBuffer.readUnsignedShort();
		switch(revision) {
		case 317:
			Connect.setRevisionType(RevisionType.THREE_ONE_SEVEN);
			break;
		case 562:
			Connect.setRevisionType(RevisionType.FIVE_SIXTY_TWO);
			break;
		} */
		channel.write(new NettyPacketBuffer().writeByte((byte) 2).writeByte((byte) 0).writeByte((byte) 0));
		new Login(channel/*, (short) version, name, pass*/);
		channel.getPipeline().replace("decoder", "decoder", new GameDecoder());
		// player.write(new PacketBuilder(249).putByteA(1).putLEShortA(player.getIndex()).toPacket());
		// player.write(new PacketBuilder(107).toPacket());
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getOpcode()
	 */
	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 16;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getSize()
	 */
	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
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
	 * Sets the revision.
	 * 
	 * @param revisionType
	 * 			The type of revision to set.
	 */
	public static void setRevisionType(final RevisionType revisionType) {
		Connect.revisionType = revisionType;
	}

	/**
	 * Gets the revision.
	 * 
	 * @return revisionType
	 * 			The type of revision to get.
	 */
	public static RevisionType getRevisionType() {
		return Connect.revisionType;
	}
}