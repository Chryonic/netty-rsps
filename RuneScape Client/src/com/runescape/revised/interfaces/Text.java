package com.runescape.revised.interfaces;

import com.runescape.revised.click.Clickable;

public class Text implements Clickable {

	private String text;
	
	public Text(String text) {
		this.setText(text);
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
}