package com.runescape.revised.content.object;

public class ObjectException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObjectException() {
		super();
	}
	
	public ObjectException(String message) {
		super(message);
	}
	
	public ObjectException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ObjectException(Throwable cause) {
		super(cause);
	}
}