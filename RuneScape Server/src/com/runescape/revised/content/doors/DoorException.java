package com.runescape.revised.content.doors;

public class DoorException extends Exception {

	private static final long serialVersionUID = 1L;

	public DoorException() {
		super();
	}
	
	public DoorException(String message) {
		super(message);
	}
	
	public DoorException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DoorException(Throwable cause) {
		super(cause);
	}
}