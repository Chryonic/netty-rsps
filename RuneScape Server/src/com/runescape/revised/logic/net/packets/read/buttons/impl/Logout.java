package com.runescape.revised.logic.net.packets.read.buttons.impl;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.Priority;
import com.runescape.revised.logic.entity.player.Rank;
import com.runescape.revised.logic.net.packets.read.buttons.Button;

public class Logout extends Button {

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rank getRank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executePacket(final Channel channel) {
		// TODO Auto-generated method stub

	}

	@Override
	public Priority getPriority() {
		// TODO Auto-generated method stub
		return null;
	}
}