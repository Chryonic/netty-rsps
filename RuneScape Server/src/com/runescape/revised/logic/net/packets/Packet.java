package com.runescape.revised.logic.net.packets;

public abstract class Packet {

	public abstract void executePacket();
	public abstract short getOpcode();
	public abstract byte getSize();
	public abstract VariableType getVariableType();
}