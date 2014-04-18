package com.runescape.revised.interfaces.impl.levelup;

public enum SkillType {

	ATTACK, STRENGTH, HITPOINTS, DUNGEONEERING, MAGE, PRAYER, HERBLORE, CONSTRUCTION, FARMING, AGILITY,
	CRAFTING, DEFENSE, RUNECRAFTING, HUNTER, SLAYER, FLETCHING, WOODCUTTING, FIREMAKING, MINING, SMITHING,
	FISHING, COOKING, SUMMONING, DIVINATION;
	
	private int interfaceID;

	public void setInterfaceID(int interfaceID) {
		this.interfaceID = interfaceID;
	}

	public int getInterfaceID() {
		return this.interfaceID;
	}
}