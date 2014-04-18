package com.runescape.revised.media.tabarea;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.runescape.revised.Sprite;
import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.media.threedworld.LocationArea;

public class TabArea extends Sprite {

	private Tab[] tabs;
	
	public TabArea() {
		this.setTabs(new Tab[14]);
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return new Location((short) 519, (short) 191, (byte) -1);
	}

	@Override
	public LocationArea getLocationArea() {
		// TODO Auto-generated method stub
		return LocationArea.TAB_AREA;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return new ImageIcon("./images/tabarea.png").getImage();
	}

	@Override
	public Image getHoverImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTabs(Tab[] tabs) {
		this.tabs = tabs;
	}

	public Tab[] getTabs() {
		return tabs;
	}

	@Override
	public Image getClickedImage() {
		// TODO Auto-generated method stub
		return null;
	}
}