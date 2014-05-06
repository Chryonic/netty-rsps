package com.runescape.revised.logic.net.packets.read.command.impl;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.Priority;
import com.runescape.revised.logic.entity.player.Rank;
import com.runescape.revised.logic.net.packets.read.command.Command;

public class Yell extends Command {

	@Override
	public Rank getRank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte getID() {
		// TODO Auto-generated method stub
		return 0;
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