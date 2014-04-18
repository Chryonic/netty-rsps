package com.runescape.revised.content.quest;

public class QuestException extends Exception {

	private static final long serialVersionUID = 1L;

	public QuestException() {
		super();
	}
	
	public QuestException(String message) {
		super(message);
	}
	
	public QuestException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public QuestException(Throwable cause) {
		super(cause);
	}
}