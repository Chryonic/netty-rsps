package com.runescape.revised.content.skill.mining;

public class Mining implements Prospectable {

	private Ore ore;
	private Pickaxe pickaxe;

	public Mining(final Ore ore, final Pickaxe pickaxe) {
		this.setOre(ore);
		this.setPickaxe(pickaxe);
	}

	public void setOre(final Ore ore) {
		this.ore = ore;
	}

	public Ore getOre() {
		return this.ore;
	}

	public void setPickaxe(final Pickaxe pickaxe) {
		this.pickaxe = pickaxe;
	}

	public Pickaxe getPickaxe() {
		return this.pickaxe;
	}
}