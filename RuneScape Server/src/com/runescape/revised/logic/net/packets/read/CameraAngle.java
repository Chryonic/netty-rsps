package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class CameraAngle extends GamePacket {

	public CameraAngle() {
		super((byte) 86, VariableType.FIXED);
		// TODO Auto-generated constructor stub
	} // 4

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		// writeShort(int)
	}
}