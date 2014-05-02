package com.runescape.revised;

/**
 * Represents a system for all systems
 * within the game.
 * 
 * @author Josh
 *
 */
public class System {

	/**
	 * The system instance.
	 */
	private static System system;

	/**
	 * Sets the system.
	 * 
	 * @param system
	 * 			The system to set.
	 */
	public static void setSystem(System system) {
		System.system = system;
	}

	/**
	 * Gets the system.
	 * 
	 * @return system
	 * 			The system to get.
	 */
	public static System getSystem() {
		if (System.system == null) {
			new System();
		}
		return System.system;
	}
}