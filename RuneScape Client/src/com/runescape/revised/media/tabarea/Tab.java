package com.runescape.revised.media.tabarea;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.runescape.revised.Sprite;
import com.runescape.revised.media.threedworld.Location;
// import com.runescape.revised.interfaces.RSInterface;
import com.runescape.revised.media.threedworld.LocationArea;

/**
 * Represents a tab within the tab
 * area.
 * 
 * @author Josh
 *
 */
public abstract class Tab extends Sprite {
	
	/**
	 * Gets the interface's ID.
	 * 
	 * @return interfaceID
	 * 			The interface ID.
	 */
	public abstract int getInterfaceID();

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.Sprite#getLocation()
	 */
	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return new Location((short) 0, (short) 0, (byte) -1);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.Sprite#getLocationArea()
	 */
	@Override
	public LocationArea getLocationArea() {
		// TODO Auto-generated method stub
		return LocationArea.TAB_AREA;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.Sprite#getImage()
	 */
	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return new ImageIcon("./images/").getImage();
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.Sprite#getHoverImage()
	 */
	@Override
	public Image getHoverImage() {
		// TODO Auto-generated method stub
		return null;
	}
}