package com.runescape.revised.content.sewers;

public class SewerException extends Exception {

	private static final long serialVersionUID = 1L;

	public SewerException() {
		super();
	}
	
	public SewerException(String message) {
		super(message);
	}
	
	public SewerException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SewerException(Throwable cause) {
		super(cause);
	}
}