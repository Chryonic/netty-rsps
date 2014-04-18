package com.runescape.revised.content.dungeon;

public class DungeonException extends Exception {

	private static final long serialVersionUID = 1L;

	public DungeonException() {
		super();
	}
	
	public DungeonException(String message) {
		super(message);
	}
	
	public DungeonException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DungeonException(Throwable cause) {
		super(cause);
	}
}