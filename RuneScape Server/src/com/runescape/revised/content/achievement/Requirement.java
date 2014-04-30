package com.runescape.revised.content.achievement;

import com.runescape.revised.content.skill.SkillType;

public class Requirement {

	private byte level;
	private SkillType skillType;
	
	public Requirement(final byte level, final SkillType skillType) {
		this.setLevel(level);
		this.setSkillType(skillType);
	}
	
	public void setLevel(final byte level) {
		this.level = level;
	}
	
	public byte getLevel() {
		return this.level;
	}
	
	public void setSkillType(final SkillType skillType) {
		this.skillType = skillType;
	}
	
	public SkillType getSkillType() {
		return this.skillType;
	}
}