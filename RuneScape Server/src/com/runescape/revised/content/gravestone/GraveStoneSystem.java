package com.runescape.revised.content.gravestone;

import com.runescape.revised.system.System;

public class GraveStoneSystem extends System {

	private GraveStone graveStone;

	@Override
	public void executeSystem() {

	}

	public void setGraveStone(final GraveStone graveStone) {
		this.graveStone = graveStone;
	}

	public GraveStone getGraveStone() {
		return this.graveStone;
	}
}