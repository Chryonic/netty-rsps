package com.runescape.revised.logic.net.packets.read;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.VariableType;
import com.runescape.revised.logic.net.packets.codec.game.GamePacket;

public class CharacterDesignScreen extends GamePacket {

	public CharacterDesignScreen() {
		super((byte) 101, VariableType.FIXED);
		// TODO Auto-generated constructor stub
	} // 13

	@Override
	public void executePacket(Channel channel) {
		// TODO Auto-generated method stub
		// stream.writeWordBigEndian(aBoolean1047 ? 0 : 1);
		// for(int i1 = 0; i1 < 7; i1++)
			// stream.writeWordBigEndian(anIntArray1065[i1]);

		// for(int l1 = 0; l1 < 5; l1++)
			// stream.writeWordBigEndian(anIntArray990[l1]);
	}
}