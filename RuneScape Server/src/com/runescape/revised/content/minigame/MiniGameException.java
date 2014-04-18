package com.runescape.revised.content.minigame;

public class MiniGameException extends Exception {

	private static final long serialVersionUID = 1L;

	public MiniGameException() {
		super();
	}
	
	public MiniGameException(String message) {
		super(message);
	}
	
	public MiniGameException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MiniGameException(Throwable cause) {
		super(cause);
	}
}