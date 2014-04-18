package com.runescape.model.players;

public interface PacketType {
	
	public void processPacket(Client c, int packetType, int packetSize);
}