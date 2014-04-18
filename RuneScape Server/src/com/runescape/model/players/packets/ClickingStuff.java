package com.runescape.model.players.packets;

import com.runescape.model.players.Client;
import com.runescape.model.players.PacketType;
import com.runescape.util.Misc;

/**
 * Clicking stuff (interfaces)
 **/
public class ClickingStuff implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		if (c.inTrade) {
			if (!c.acceptedTrade) {
				Misc.println("trade reset");
			}
		}
	}
}