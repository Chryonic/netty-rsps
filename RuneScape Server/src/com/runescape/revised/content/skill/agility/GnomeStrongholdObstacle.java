package com.runescape.revised.content.skill.agility;

public enum GnomeStrongholdObstacle {

	LOG_BALANCE((byte) 7.5);
	
	private byte experience;
	
	GnomeStrongholdObstacle(byte experience) {
		this.setExperience(experience);
	}
	
	public void setExperience(byte experience) {
		this.experience = experience;
	}
	
	public byte getExperience() {
		return this.experience;
	}
}