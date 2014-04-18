package com.runescape.revised.packets.write.command.impl;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.model.entity.player.Rank;
import com.runescape.revised.packets.write.command.Command;

public class CheckInterface extends Command {

	@Override
	public Rank getRank() {
		return Rank.ADMINISTRATOR;
	}

	@Override
	public void executePacket(GameClient c, int opcode, int packetSize) {
		// TODO Auto-generated method stub
		
	}
}