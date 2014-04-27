package com.runescape.revised.logic.net.packets;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.LogicSystem;

public class PacketSystem extends LogicSystem {

	private static PacketSystem packetSystem;
	
	public PacketSystem() {}
	
	public void throwPacket(Packet packet, ChannelBuffer channelBuffer, Channel channel) {
		packet.executePacket(channelBuffer, channel);
	}

	public static void setPacketSystem(PacketSystem packetSystem) {
		PacketSystem.packetSystem = packetSystem;
	}

	public static PacketSystem getPacketSystem() {
		if (PacketSystem.packetSystem == null) {
			PacketSystem.setPacketSystem(new PacketSystem());
		}
		return PacketSystem.packetSystem;
	}
}