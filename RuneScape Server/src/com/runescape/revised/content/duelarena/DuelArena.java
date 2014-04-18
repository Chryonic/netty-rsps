package com.runescape.revised.content.duelarena;

import com.runescape.model.players.Player;
import com.runescape.revised.content.location.Location;

public class DuelArena {

	private Location[] boxLocations;
	private Player[] players;

	public void setBoxLocations(Location[] boxLocations) {
		this.boxLocations = boxLocations;
	}

	public Location[] getBoxLocations() {
		return this.boxLocations;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Player[] getPlayers() {
		return this.players;
	}
}