package com.runescape.revised.media.tabarea;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.runescape.revised.Sprite;
import com.runescape.revised.media.threedworld.Location;
// import com.runescape.revised.interfaces.RSInterface;
import com.runescape.revised.media.threedworld.LocationArea;

public abstract class Tab extends Sprite {
	
	public abstract int getInterfaceID();

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return new Location((short) 0, (short) 0, (byte) -1);
	}

	@Override
	public LocationArea getLocationArea() {
		// TODO Auto-generated method stub
		return LocationArea.TAB_AREA;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return new ImageIcon("./images/").getImage();
	}

	@Override
	public Image getHoverImage() {
		// TODO Auto-generated method stub
		return null;
	}

}