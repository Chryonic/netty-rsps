package com.runescape.revised.logic.net.packets;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.LogicSystem;

public class PacketSystem extends LogicSystem {

	private static PacketSystem packetSystem;
	
	public PacketSystem() {}
	
	public void throwPacket(final Packet packet, final Channel channel) {
		packet.executePacket(channel);
	}

	public static void setPacketSystem(final PacketSystem packetSystem) {
		PacketSystem.packetSystem = packetSystem;
	}

	public static PacketSystem getPacketSystem() {
		if (PacketSystem.packetSystem == null) {
			PacketSystem.setPacketSystem(new PacketSystem());
		}
		return PacketSystem.packetSystem;
	}
}