package com.runescape.revised.media.tabarea;

public enum TabType {

	COMBAT(0), SKILLS(0), QUEST(0), INVENTORY(0), ARMOUR(0), PRAYER(0), MAGIC(0), FRIENDS(0), IGNORE(0), LOGOUT(0),
	SETTINGS(0), RUN(0), MUSIC(0);
	
	private int id;
	
	TabType(int id) {
		this.setID(id);
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
}