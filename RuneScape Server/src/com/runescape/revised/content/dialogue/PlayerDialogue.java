package com.runescape.revised.content.dialogue;

public abstract class PlayerDialogue extends Dialogue {
	
	@Override
	public DialogueType getDialogueType() {
		return DialogueType.PLAYER;
	}
}