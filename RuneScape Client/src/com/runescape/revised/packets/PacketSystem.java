package com.runescape.revised.packets;

public class PacketSystem {

	private static PacketSystem packetSystem;

	public static void setPacketSystem(PacketSystem packetSystem) {
		PacketSystem.packetSystem = packetSystem;
	}

	public static PacketSystem getPacketSystem() {
		return PacketSystem.packetSystem;
	}
}