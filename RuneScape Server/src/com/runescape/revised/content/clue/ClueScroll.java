package com.runescape.revised.content.clue;

import com.runescape.revised.content.Content;

public class ClueScroll extends Content {

	private LevelDifficulty levelDifficulty;

	public void setLevelDifficulty(LevelDifficulty levelDifficulty) {
		this.levelDifficulty = levelDifficulty;
	}

	public LevelDifficulty getLevelDifficulty() {
		return this.levelDifficulty;
	}
}