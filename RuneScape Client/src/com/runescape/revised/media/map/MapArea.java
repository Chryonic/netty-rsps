package com.runescape.revised.media.map;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.runescape.revised.Sprite;
import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.media.threedworld.LocationArea;

public class MapArea extends Sprite {

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return new Location((short) 519, (short) 23, (byte) -1);
	}

	@Override
	public LocationArea getLocationArea() {
		// TODO Auto-generated method stub
		return LocationArea.MAP;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return new ImageIcon("./images/maparea.png").getImage();
	}

	@Override
	public Image getHoverImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getClickedImage() {
		// TODO Auto-generated method stub
		return null;
	}
}