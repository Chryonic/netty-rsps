package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.login.ConnectionType;
import com.runescape.revised.logic.net.packets.codec.login.LoginDecoder;
// import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

public class Request extends Packet {

	@Override
	public void executePacket(ChannelBuffer channelBuffer, Channel channel) {
		// TODO Auto-generated method stub
		LoginDecoder.setConnectionType(ConnectionType.LOGIN);
		channelBuffer.readUnsignedByte();
		channelBuffer.readUnsignedByte();
		LoginDecoder.setConnectionType(ConnectionType.NEW_CONNECTION);
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 14;
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
	}
}