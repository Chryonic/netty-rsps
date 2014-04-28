package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.PacketBuffer;
import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.login.ConnectionType;
import com.runescape.revised.logic.net.packets.codec.login.Login;
import com.runescape.revised.logic.net.packets.codec.login.LoginDecoder;
import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

public class Connect extends LoginPacket {

	@Override
	public void executePacket(Channel channel) {
		System.out.println("Now logging in...");
		channel.write(new PacketBuffer().writeByte((byte) 2).writeByte((byte) 0).writeByte((byte) 0));
		new Login(channel/*, (short) version, name, pass*/);
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		if (LoginDecoder.getConnectionType() == ConnectionType.NEW_CONNECTION) {
			return 16;
		}
		return 18;
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