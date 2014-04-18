package com.runescape.revised.mission;

public class MissionSystem {

	private static MissionSystem missionSystem;

	public static void setMissionSystem(MissionSystem missionSystem) {
		MissionSystem.missionSystem = missionSystem;
	}

	public static MissionSystem getMissionSystem() {
		return MissionSystem.missionSystem;
	}
}