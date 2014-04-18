package com.runescape.revised.content.event;

public class EventException extends Exception {

	private static final long serialVersionUID = 1L;

	public EventException() {
		super();
	}
	
	public EventException(String message) {
		super(message);
	}
	
	public EventException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EventException(Throwable cause) {
		super(cause);
	}
}