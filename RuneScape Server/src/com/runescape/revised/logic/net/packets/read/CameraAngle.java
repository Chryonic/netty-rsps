package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class CameraAngle extends Packet {

	@Override
	public void executePacket(ChannelBuffer channelBuffer, Channel channel) {
		// TODO Auto-generated method stub
		// writeShort(int)
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 86;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}