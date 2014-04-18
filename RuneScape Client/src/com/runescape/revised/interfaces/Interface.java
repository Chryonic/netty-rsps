package com.runescape.revised.interfaces;

import com.runescape.revised.Sprite;
import com.runescape.revised.media.threedworld.Location;

public abstract class Interface {

	public abstract int getID();
	public abstract Sprite[] getSprites();
	public abstract Location[] getLocations();
	public abstract Button[] getButtons();
	public abstract Text[] getText();
}