package com.runescape.revised.content.achievement;

import com.runescape.revised.system.System;

public class AchievementSystem extends System {

	private Achievement[] achievements;

	@Override
	public void executeSystem() {

	}

	public void setAchievements(final Achievement... achievements) {
		this.achievements = achievements;
	}

	public Achievement[] getAchievements() {
		return this.achievements;
	}
}