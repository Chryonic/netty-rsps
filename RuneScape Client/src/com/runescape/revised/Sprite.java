package com.runescape.revised;

import java.awt.Image;

import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.media.threedworld.LocationArea;

/**
 * The Sprite class used to create images
 * in the Game.
 * 
 * @author Josh
 *
 */
public abstract class Sprite {

	/**
	 * Getter location of the sprite.
	 * 
	 * @return location
	 * 			The location of the sprite.
	 */
	public abstract Location getLocation();
	
	/**
	 * Gets the location's area.
	 * 
	 * @return locationArea
	 * 			The area of the location.
	 */
	public abstract LocationArea getLocationArea();
	
	/**
	 * Gets the image.
	 * 
	 * @return image
	 * 			The image to get.
	 */
	public abstract Image getImage();
	
	/**
	 * Gets the hover image.
	 * 
	 * @return hoverImage
	 * 			The hover image.
	 */
	public abstract Image getHoverImage();
	
	/**
	 * Gets the clicked image.
	 * 
	 * @return clickedImage
	 */
	public abstract Image getClickedImage();
}