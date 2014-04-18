package com.runescape.revised.media.threedworld;

public class Location {

	private short x;
	private short y;
	private byte z;
	
	public Location(short x, short y, byte z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
	}
	
	public void setX(short x) {
		this.x = x;
	}
	
	public short getX() {
		return this.x;
	}
	
	public void setY(short y) {
		this.y = y;
	}
	
	public short getY() {
		return this.y;
	}
	
	public void setZ(byte z) {
		this.z = z;
	}
	
	public byte getZ() {
		return this.z;
	}
}