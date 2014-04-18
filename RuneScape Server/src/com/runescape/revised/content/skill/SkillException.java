package com.runescape.revised.content.skill;

public class SkillException extends Exception {

	private static final long serialVersionUID = 1L;

	public SkillException() {
		super();
	}
	
	public SkillException(String message) {
		super(message);
	}
	
	public SkillException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SkillException(Throwable cause) {
		super(cause);
	}
}