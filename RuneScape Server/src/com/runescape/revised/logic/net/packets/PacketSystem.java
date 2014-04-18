package com.runescape.revised.logic.net.packets;

import com.runescape.revised.logic.LogicSystem;

public class PacketSystem extends LogicSystem {

	private static PacketSystem packetSystem;
	
	public void throwPacket(Packet packet) {
		packet.executePacket();
	}

	public static void setPacketSystem(PacketSystem packetSystem) {
		PacketSystem.packetSystem = packetSystem;
	}

	public static PacketSystem getPacketSystem() {
		return PacketSystem.packetSystem;
	}
}