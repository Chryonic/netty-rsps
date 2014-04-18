package com.runescape.revised.media.threedworld;

public enum LocationArea {

	MAP, CHAT, TAB_AREA, THREE_D, GAME_AREA;
	
	private Location location;
	
	// LocationArea(Location location) {
	// 	this.setLocation(location);
	// }
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}
}