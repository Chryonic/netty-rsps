package com.runescape.revised.content.clue;

import com.runescape.revised.system.System;

public class ClueScrollSystem extends System {

	private ClueScroll clueScroll;

	@Override
	public void executeSystem() {

	}

	public void setClueScroll(final ClueScroll clueScroll) {
		this.clueScroll = clueScroll;
	}

	public ClueScroll getClueScroll() {
		return this.clueScroll;
	}
}