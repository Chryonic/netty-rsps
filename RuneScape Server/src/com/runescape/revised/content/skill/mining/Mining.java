package com.runescape.revised.content.skill.mining;

public class Mining implements Prospectable {

	private Ore ore;
	private Pickaxe pickaxe;
	
	public void setOre(Ore ore) {
		this.ore = ore;
	}
	
	public Ore getOre() {
		return this.ore;
	}

	public void setPickaxe(Pickaxe pickaxe) {
		this.pickaxe = pickaxe;
	}

	public Pickaxe getPickaxe() {
		return pickaxe;
	}
}