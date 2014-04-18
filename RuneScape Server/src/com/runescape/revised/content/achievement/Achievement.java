package com.runescape.revised.content.achievement;

import com.runescape.revised.content.location.LocationType;

public class Achievement {

	private Difficulty difficulty;
	private LocationType locationType;
	private Requirement requirement;

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Difficulty getDifficulty() {
		return this.difficulty;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	public LocationType getLocationType() {
		return this.locationType;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public Requirement getRequirement() {
		return this.requirement;
	}
}