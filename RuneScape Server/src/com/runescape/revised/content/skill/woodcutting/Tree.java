package com.runescape.revised.content.skill.woodcutting;

import com.runescape.revised.MemberType;

public enum Tree {

	TREE, EVERGREEN, ACHEY, OAK, WILLOW, TEAK, MAPLE, HOLLOW, MAHOGANY, ARCTIC, EUCALYPTUS,
	IVY, YEW, MAGIC, CURSED_MAGIC, BLOODWOOD, ELDER, CRYSTAL;

	private byte level;
	private byte experience;
	private MemberType memberType;
	
	public void setLevel(byte level) {
		this.level = level;
	}
	
	public byte getLevel() {
		return this.level;
	}
	
	public void setExperience(byte experience) {
		this.experience = experience;
	}
	
	public byte getExperience() {
		return this.experience;
	}
	
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	
	public MemberType getMemberType() {
		return this.memberType;
	}
}