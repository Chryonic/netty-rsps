package com.runescape.revised.content.skill.combat;

import com.runescape.revised.logic.entity.Entity;

public class Combat {

	private Entity defender;
	private Entity attacker;
	
	public void setDefender(Entity defender) {
		this.defender = defender;
	}
	
	public Entity getDefender() {
		return defender;
	}

	public void setAttacker(Entity attacker) {
		this.attacker = attacker;
	}

	public Entity getAttacker() {
		return attacker;
	}
}