package com.runescape.revised.logic.net.packets;

import org.jboss.netty.channel.Channel;

public class Packet {
	
	private short opcode;
	private VariableType variableType;
	
	public Packet(short opcode, VariableType variableType) {
		this.setOpcode(opcode);
		this.setVariableType(variableType);
	}

	/**
	 * Executes the packet.
	 * 
	 * @param channel
	 * 			The channel to execute the packet.
	 */
	public void executePacket(Channel channel) {}


	public void setOpcode(short opcode) {
		this.opcode = opcode;
	}
	
	public short getOpcode() {
		return this.opcode;
	}

	public void setVariableType(VariableType variableType) {
		this.variableType = variableType;
	}

	public VariableType getVariableType() {
		return this.variableType;
	}
}