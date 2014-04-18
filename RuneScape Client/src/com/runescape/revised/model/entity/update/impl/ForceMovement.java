package com.runescape.revised.model.entity.update.impl;

import com.runescape.revised.media.threedworld.Location;

public class ForceMovement {

	private Location location;
	private int startSpeed;
	private int endSpeed;
	private int facingDirection;
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setStartSpeed(int startSpeed) {
		this.startSpeed = startSpeed;
	}
	
	public int getStartSpeed() {
		return startSpeed;
	}
	
	public void setEndSpeed(int endSpeed) {
		this.endSpeed = endSpeed;
	}
	
	public int getEndSpeed() {
		return endSpeed;
	}
	
	public void setFacingDirection(int facingDirection) {
		this.facingDirection = facingDirection;
	}
	
	public int getFacingDirection() {
		return facingDirection;
	}
}