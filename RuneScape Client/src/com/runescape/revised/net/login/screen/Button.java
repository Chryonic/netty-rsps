package com.runescape.revised.net.login.screen;

import java.awt.Image;

import com.runescape.revised.Sprite;
import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.media.threedworld.LocationArea;

public class Button extends Sprite {

	private String text;
	
	public Button(String text) {
		this.setText(text);
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationArea getLocationArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
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

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
}