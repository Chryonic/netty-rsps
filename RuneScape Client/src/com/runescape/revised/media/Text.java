package com.runescape.revised.media;

import java.awt.Color;

public class Text {

	private Color color;
	private byte size;
	private String fontName;
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setSize(byte size) {
		this.size = size;
	}
	
	public byte getSize() {
		return this.size;
	}
	
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	
	public String getFontName() {
		return this.fontName;
	}
}