package com.runescape.revised.content.travel;

import com.runescape.revised.content.location.Location;
import com.runescape.revised.logic.entity.npc.NPC;

public class Travel {

	private Location location;
	private NPC npc;

	public void setLocation(final Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setNPC(final NPC npc) {
		this.npc = npc;
	}

	public NPC getNPC() {
		return this.npc;
	}
}