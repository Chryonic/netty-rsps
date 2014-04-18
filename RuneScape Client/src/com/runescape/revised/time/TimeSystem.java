package com.runescape.revised.time;

public class TimeSystem {

	private static TimeSystem timeSystem;

	public static void setTimeSystem(TimeSystem timeSystem) {
		TimeSystem.timeSystem = timeSystem;
	}

	public static TimeSystem getTimeSystem() {
		return TimeSystem.timeSystem;
	}
}