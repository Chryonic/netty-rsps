package com.runescape.revised.model.entity;

import java.util.Map;

import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.model.Model;

public abstract class Entity extends Model implements Walkable {

	private Location location;
	private byte age;
	private Map<Object, Object> characertisticMap;

	public void setLocation(final Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setAge(final byte age) {
		this.age = age;
	}

	public byte getAge() {
		return this.age;
	}

	public void setCharacteristicMap(final Map<Object, Object> characertisticMap) {
		this.characertisticMap = characertisticMap;
	}

	public Map<Object, Object> getCharacteristicMap() {
		return this.characertisticMap;
	}
}