package com.runescape.revised.model.entity.player;

public enum Rank {

	PLAYER((byte) 0), MODERATOR((byte) 1), ADMINISTRATOR((byte) 2), OWNER((byte) 3);
	
	private byte id;
	
	Rank(byte id) {
		this.setID(id);
	}
	
	public void setID(byte id) {
		this.id = id;
	}
	
	public byte getID() {
		return this.id;
	}
}