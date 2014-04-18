package com.runescape.revised.media.chat;

import java.awt.Image;

import com.runescape.revised.Sprite;
import com.runescape.revised.media.threedworld.Location;
import com.runescape.revised.media.threedworld.LocationArea;

public class ChatButton extends Sprite {

	// private RGBImage chatButtonImage
	private ChatButtonType chatButtonType;
	private ChatButtonStatus chatButtonStatus;
	private String text;

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

	public void setChatButtonType(ChatButtonType chatButtonType) {
		this.chatButtonType = chatButtonType;
	}

	public ChatButtonType getChatButtonType() {
		return this.chatButtonType;
	}

	public void setChatButtonStatus(ChatButtonStatus chatButtonStatus) {
		this.chatButtonStatus = chatButtonStatus;
	}

	public ChatButtonStatus getChatButtonStatus() {
		return this.chatButtonStatus;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
}