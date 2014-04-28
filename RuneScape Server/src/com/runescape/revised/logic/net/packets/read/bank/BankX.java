package com.runescape.revised.logic.net.packets.read.bank;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.codec.game.GamePacket;
import com.runescape.revised.logic.net.packets.VariableType;

public class BankX extends GamePacket {

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 135;// 208
	}

	@Override
	public byte getSize() {
		// TODO Auto-generated method stub
		return 6;// 4
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return VariableType.FIXED;
	}
}