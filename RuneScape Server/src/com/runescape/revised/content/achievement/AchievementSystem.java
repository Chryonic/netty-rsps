package com.runescape.revised.content.achievement;

public class AchievementSystem {

	private Achievement[] achievements;

	public void setAchievements(final Achievement... achievements) {
		this.achievements = achievements;
	}

	public Achievement[] getAchievements() {
		return this.achievements;
	}
}