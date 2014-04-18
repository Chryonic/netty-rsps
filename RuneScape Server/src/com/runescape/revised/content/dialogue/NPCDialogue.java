package com.runescape.revised.content.dialogue;

public abstract class NPCDialogue extends Dialogue {

	@Override
	public DialogueType getDialogueType() {
		return DialogueType.NPC;
	}
}