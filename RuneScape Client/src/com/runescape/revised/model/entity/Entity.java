package com.runescape.revised.model.entity;

import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.model.Model;

public abstract class Entity extends Model implements Walkable {

	private Location location;
	private byte age;
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return this.location;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public byte getAge() {
		return this.age;
	}
}