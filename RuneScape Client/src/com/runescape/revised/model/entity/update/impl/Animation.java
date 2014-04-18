package com.runescape.revised.model.entity.update.impl;

public class Animation {

	private short id;
	private byte delay;
	
	public void setID(short id) {
		this.id = id;
	}
	
	public short getID() {
		return id;
	}
	
	public void setDelay(byte delay) {
		this.delay = delay;
	}
	
	public byte getDelay() {
		return delay;
	}
}