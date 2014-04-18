package com.runescape.revised.content.randomevent;

import com.runescape.revised.system.System;

public class RandomEventSystem extends System {

	private static RandomEventSystem randomEventSystem;

	public static void setRandomEventSystem(RandomEventSystem randomEventSystem) {
		RandomEventSystem.randomEventSystem = randomEventSystem;
	}

	public static RandomEventSystem getRandomEventSystem() {
		return RandomEventSystem.randomEventSystem;
	}
}