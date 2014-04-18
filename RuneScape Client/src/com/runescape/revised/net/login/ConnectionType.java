package com.runescape.revised.net.login;

public enum ConnectionType {

	LOGIN((byte) 14), UPDATE((byte) 15), NEW_CONNECTION((byte) 16), RECONNECTING((byte) 18);
	
	private byte connectionID;
	
	ConnectionType(byte ctonnectionID) {
		this.setConnectionID(connectionID);
	}
	
	public void setConnectionID(byte connectionID) {
		this.connectionID = connectionID;
	}
	
	public byte getConnectionID() {
		return this.connectionID;
	}
}