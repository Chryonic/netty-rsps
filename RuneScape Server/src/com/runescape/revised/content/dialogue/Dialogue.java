package com.runescape.revised.content.dialogue;

import com.runescape.revised.content.Content;

public abstract class Dialogue extends Content {

	public abstract short getID();
	public abstract DialogueOption getDialogueOption();
	public abstract DialogueType getDialogueType();
	public abstract String[] getText();
	public abstract void executeDialogue();
	
	// get npc text
	// get player text
	// get options
	// send next dialogue
	// repeat
}