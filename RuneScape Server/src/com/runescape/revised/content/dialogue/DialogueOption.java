package com.runescape.revised.content.dialogue;

public enum DialogueOption {

	TWO_OPTIONS((short) 0),
	THREE_OPTIONS((short) 0),
	FOUR_OPTIONS((short) 0);
	
	private short optionID;
	
	DialogueOption(short optionID) {
		this.setOptionID(optionID);
	}
	
	public void setOptionID(short optionID) {
		this.optionID = optionID;
	}
	
	public short getOptionID() {
		return this.optionID;
	}
}