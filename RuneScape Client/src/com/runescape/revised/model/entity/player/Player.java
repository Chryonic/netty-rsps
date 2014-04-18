package com.runescape.revised.model.entity.player;

import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.model.entity.Entity;

public class Player extends Entity {

	private String username;
	private String password;
	private byte userID;

	@Override
	public void loadModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location[] getLocations() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setUserID(byte userID) {
		this.userID = userID;
	}

	public byte getUserID() {
		return this.userID;
	}
}