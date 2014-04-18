package com.runescape.revised.logic.path;

public abstract class Path {
	
	private Tile[] walkableTiles;

	public void setWalkableTiles(Tile[] walkableTiles) {
		this.walkableTiles = walkableTiles;
	}

	public Tile[] getWalkableTiles() {
		return this.walkableTiles;
	}
}