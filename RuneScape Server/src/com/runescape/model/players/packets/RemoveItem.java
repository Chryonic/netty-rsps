package com.runescape.model.players.packets;

import com.runescape.model.players.Client;
import com.runescape.model.players.PacketType;

/**
 * Remove Item
 **/
public class RemoveItem implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int interfaceId = c.getInStream().readUnsignedWordA();
		int removeSlot = c.getInStream().readUnsignedWordA();
		int removeId = c.getInStream().readUnsignedWordA();
		switch (interfaceId) {

		case 1688:
			break;

		case 5064:
			c.getItems().bankItem(removeId, removeSlot, 1);
			break;

		case 5382:
			c.getItems().fromBank(removeId, removeSlot, 1);
			break;

		case 3900:
			break;

		case 3823:
			break;

		case 3322:
			break;

		case 3415:
			break;

		case 6669:
			break;

		case 1119:
		case 1120:
		case 1121:
		case 1122:
		case 1123:
			break;
		}
	}

}
