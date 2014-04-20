package com.runescape.revised.logic.net.packets;

import java.util.ArrayList;
import java.util.List;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.LogicSystem;

public class PacketSystem extends LogicSystem {

	private static PacketSystem packetSystem;
	private List<Packet> packetList;
	
	PacketSystem() {
		if (PacketSystem.getPacketSystem() == null) {
			new PacketSystem();
		}
		this.setPacketList(new ArrayList<Packet>());
	}
	
	public void addPacket(Packet packet) {
		this.getPacketList().add(packet);
	}
	
	public void removePacket(Packet packet) {
		this.getPacketList().remove(packet);
	}
	
	public void throwPacket(Packet packet, ChannelBuffer channelBuffer, Channel channel) {
		packet.executePacket(channelBuffer, channel);
	}

	public static void setPacketSystem(PacketSystem packetSystem) {
		PacketSystem.packetSystem = packetSystem;
	}

	public static PacketSystem getPacketSystem() {
		return PacketSystem.packetSystem;
	}

	public void setPacketList(List<Packet> packetList) {
		this.packetList = packetList;
	}

	public List<Packet> getPacketList() {
		return this.packetList;
	}
}