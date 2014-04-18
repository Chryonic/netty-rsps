package com.runescape.revised.model.entity.update.impl;

import com.runescape.revised.Damage;

public class Hit {

	private Damage damage;
	private HitType hitType;

	public void setDamage(Damage damage) {
		this.damage = damage;
	}

	public Damage getDamage() {
		return damage;
	}

	public void setHitType(HitType hitType) {
		this.hitType = hitType;
	}

	public HitType getHitType() {
		return hitType;
	}
}