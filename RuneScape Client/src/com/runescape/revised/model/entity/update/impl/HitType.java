package com.runescape.revised.model.entity.update.impl;

public enum HitType {

	NONE, NORMAL, POISON, DISEASE;
	
	private byte hitID;
	
	public void setHitID(byte hitID) {
		this.hitID = hitID;
	}
	
	public int getHitID() {
		return this.hitID;
	}
}