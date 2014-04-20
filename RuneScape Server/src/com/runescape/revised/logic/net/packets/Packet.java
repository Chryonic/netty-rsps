package com.runescape.revised.logic.net.packets;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

public abstract class Packet {

	public abstract void executePacket(ChannelBuffer channelBuffer, Channel channel);
	public abstract short getOpcode();
	public abstract byte getSize();
	public abstract VariableType getVariableType();
}