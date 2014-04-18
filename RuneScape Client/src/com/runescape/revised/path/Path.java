package com.runescape.revised.path;

import com.runescape.revised.media.threedworld.Tile;

public abstract class Path {

	private Tile[] walkableTiles;

	public void setWalkableTiles(Tile[] walkableTiles) {
		this.walkableTiles = walkableTiles;
	}

	public Tile[] getWalkableTiles() {
		return this.walkableTiles;
	}
}