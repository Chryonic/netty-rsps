package com.runescape.revised;

import java.awt.Image;

import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.media.threedworld.LocationArea;

public abstract class Sprite {

	public abstract Location getLocation();
	public abstract LocationArea getLocationArea();
	public abstract Image getImage();
	public abstract Image getHoverImage();
	public abstract Image getClickedImage();
}