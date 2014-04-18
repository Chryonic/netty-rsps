package com.runescape.revised.media.threedworld;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.runescape.revised.Sprite;

public class GameArea extends Sprite {

	@Override
	public Location getLocation() {
		return new Location((short) 0, (short) 0, (byte) -1);
	}

	@Override
	public LocationArea getLocationArea() {
		return LocationArea.GAME_AREA;
	}

	@Override
	public Image getImage() {
		return new ImageIcon("./images/gamearea.png").getImage();
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