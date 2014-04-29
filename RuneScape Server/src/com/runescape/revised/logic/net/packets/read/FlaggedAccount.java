package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class FlaggedAccount extends GamePacket {

	public FlaggedAccount() {
		super((byte) 45, VariableType.FIXED);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}
}