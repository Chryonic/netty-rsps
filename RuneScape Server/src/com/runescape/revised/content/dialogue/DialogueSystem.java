package com.runescape.revised.content.dialogue;

import java.util.LinkedList;
import java.util.Queue;

import com.runescape.revised.system.System;

public class DialogueSystem extends System {

	private Queue<Dialogue> dialogueList;
	
	public DialogueSystem() {
		this.setDialogueList(new LinkedList<Dialogue>());
	}
	
	public void addDialogue(Dialogue dialogue) {
		this.getDialogueList().add(dialogue);
		dialogue.executeDialogue();
	}
	
	public void removeDialogue(Dialogue dialogue) {
		this.getDialogueList().remove(dialogue);
	}
	
	public void removeAllDialogues(Dialogue... dialogue) {
		this.getDialogueList().removeAll(this.getDialogueList());
	}
	
	public void setDialogueList(Queue<Dialogue> dialogueList) {
		this.dialogueList = dialogueList;
	}
	
	public Queue<Dialogue> getDialogueList() {
		return this.dialogueList;
	}
}