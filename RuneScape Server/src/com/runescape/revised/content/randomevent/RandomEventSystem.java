package com.runescape.revised.content.randomevent;

import com.runescape.revised.system.System;

public class RandomEventSystem extends System {

	private static RandomEventSystem randomEventSystem;

	@Override
	public void executeSystem() {

	}

	public static void setRandomEventSystem(final RandomEventSystem randomEventSystem) {
		RandomEventSystem.randomEventSystem = randomEventSystem;
	}

	public static RandomEventSystem getRandomEventSystem() {
		return RandomEventSystem.randomEventSystem;
	}
}