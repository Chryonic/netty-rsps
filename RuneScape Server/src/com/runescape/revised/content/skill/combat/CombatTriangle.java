package com.runescape.revised.content.skill.combat;

public enum CombatTriangle {

	MAGE(CombatType.RANGE, CombatType.MELEE), MELEE(CombatType.MAGE, CombatType.RANGE),
	RANGE(CombatType.MELEE, CombatType.MAGE);
	
	private CombatType weakness;
	private CombatType strength;
	
	CombatTriangle(CombatType weakness, CombatType strength) {
		this.setWeakness(weakness);
		this.setStrength(strength);
	}
	
	public void setWeakness(CombatType weakness) {
		this.weakness = weakness;
	}
	
	public CombatType getWeakness() {
		return this.weakness;
	}
	
	public void setStrength(CombatType strength) {
		this.strength = strength;
	}
	
	public CombatType getStrength() {
		return this.strength;
	}
}