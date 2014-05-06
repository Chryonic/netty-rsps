package com.runescape.revised.logic.entity;

import java.util.Map;

public abstract class Entity implements Attackable {

	private Map<Object, Object> characertisticMap;

	public void setCharacertisticMap(final Map<Object, Object> characertisticMap) {
		this.characertisticMap = characertisticMap;
	}

	public Map<Object, Object> getCharacertisticMap() {
		return this.characertisticMap;
	}
}