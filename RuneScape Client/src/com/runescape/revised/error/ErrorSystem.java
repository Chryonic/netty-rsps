package com.runescape.revised.error;

public class ErrorSystem {

	private static ErrorSystem errorSystem;
	
	public ErrorSystem() {
		
	}
	
	public static void setErrorSystem(ErrorSystem errorSystem) {
		ErrorSystem.errorSystem = errorSystem;
	}
	
	public static ErrorSystem getErrorSystem() {
		return ErrorSystem.errorSystem;
	}
}