package com.runescape.revised.system.area;

import java.util.Queue;

import com.runescape.revised.system.System;

/**
 * The Area within the Game/Character - anywhere basically.
 * 
 * @author Josh
 *
 */
public abstract class Area {

	/**
	 * Send the system to wherever it needs
	 * to go.
	 * 
	 * @param system
	 * 			The System that needs to be sent over.
	 * @param area
	 * 			The area for where it needs to go.
	 */
	public abstract void sendSystem(System system, Area area);

	/**
	 * Get the Systems within each Area
	 * (Foreground, Midground, Background).
	 * 
	 * @return system
	 * 			The systems to get.
	 */
	public abstract System[] getSystems();

	/**
	 * Remove the System to the Area.
	 * 
	 * @param system
	 * 			The system to remove.
	 */
	public abstract Queue<System> getSystemQueue();
}