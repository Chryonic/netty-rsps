package com.runescape.revised.content.minigame.castlewars;

import com.runescape.revised.content.location.Location;
import com.runescape.revised.content.object.Object;

public class Flag extends Object {

	private Team team;

	@Override
	public short getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return this.team;
	}
}