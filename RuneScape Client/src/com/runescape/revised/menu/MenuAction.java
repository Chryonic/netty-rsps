package com.runescape.revised.menu;

public abstract class MenuAction {
	
	private short id;
	private String name;
	
	public MenuAction(short id, String name) {
		this.setID(id);
		this.setName(name);
	}

	public abstract void executeMenuAction();

	public void setID(short id) {
		this.id = id;
	}

	public short getID() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}