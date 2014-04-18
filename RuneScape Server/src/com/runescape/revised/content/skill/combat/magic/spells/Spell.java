package com.runescape.revised.content.skill.combat.magic.spells;

import com.runescape.revised.content.skill.runecrafting.Rune;

public abstract class Spell {

	private short experience;
	
	public abstract byte getLevelNeeded();
	public abstract Rune[] getRunesNeeded();
	public abstract SpellType getSpellType();
	public abstract SpellGroup getSpellGroup();
	public abstract String getNotes();
	public abstract SpellBookType getSpellBookType();
	public abstract void castSpell();
	
	public void setExperience(short experience) {
		this.experience = experience;
	}
	
	public short getExperience() {
		return experience;
	}
}