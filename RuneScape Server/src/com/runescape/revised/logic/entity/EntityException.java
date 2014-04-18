package com.runescape.revised.logic.entity;

public class EntityException extends Exception {

	private static final long serialVersionUID = 1L;

	public EntityException() {
		super();
	}
	
	public EntityException(String message) {
		super(message);
	}
	
	public EntityException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EntityException(Throwable cause) {
		super(cause);
	}
}