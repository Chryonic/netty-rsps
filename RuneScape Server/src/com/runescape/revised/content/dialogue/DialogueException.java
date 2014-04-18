package com.runescape.revised.content.dialogue;

public class DialogueException extends Exception {

	private static final long serialVersionUID = 1L;

	public DialogueException() {
		super();
	}
	
	public DialogueException(String message) {
		super(message);
	}
	
	public DialogueException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DialogueException(Throwable cause) {
		super(cause);
	}
}