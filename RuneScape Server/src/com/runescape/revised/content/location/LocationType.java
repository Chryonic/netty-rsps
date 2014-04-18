package com.runescape.revised.content.location;

public enum LocationType {

	VARROCK(new Location()), LUMBRIDGE(new Location()), DRAYNOR(new Location()), FALADOR(new Location());
	
	private Location location;
	
	LocationType(Location location) {
		this.setLocation(location);
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return this.location;
	}
}