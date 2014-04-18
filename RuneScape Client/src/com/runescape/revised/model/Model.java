package com.runescape.revised.model;

import com.runescape.revised.media.threedworld.Location;

public abstract class Model {

	public abstract void loadModel();
	public abstract short getID();
	public abstract String getName();
	public abstract Location[] getLocations();
}