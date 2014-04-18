package com.runescape.revised;

public class System {

	private static System system;

	public static void setSystem(System system) {
		System.system = system;
	}

	public static System getSystem() {
		return System.system;
	}
}
