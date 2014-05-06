package com.runescape.revised.content.dialogue;

import java.util.LinkedList;
import java.util.Queue;

import com.runescape.revised.system.System;

public class DialogueSystem extends System {

	private Queue<Dialogue> dialogueList;

	public DialogueSystem() {
		this.setDialogueList(new LinkedList<Dialogue>());
	}

	public void addDialogue(final Dialogue dialogue) {
		this.getDialogueList().add(dialogue);
		dialogue.executeDialogue();
	}

	public void removeDialogue(final Dialogue dialogue) {
		this.getDialogueList().remove(dialogue);
	}

	public void removeAllDialogues(final Dialogue... dialogue) {
		this.getDialogueList().removeAll(this.getDialogueList());
	}

	@Override
	public void executeSystem() {

	}

	public void setDialogueList(final Queue<Dialogue> dialogueList) {
		this.dialogueList = dialogueList;
	}

	public Queue<Dialogue> getDialogueList() {
		return this.dialogueList;
	}
}