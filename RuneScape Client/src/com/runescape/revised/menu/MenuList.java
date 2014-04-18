package com.runescape.revised.menu;

public class MenuList {
	
	private short id;
	private String name;
	private MenuAction menuAction;

	public void add(short id, String name, MenuAction menuAction) {
		
	}
	
	public void remove(short id, String name, MenuAction menuAction) {
		
	}
	
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
		return this.name;
	}
	
	public void setMenuAction(MenuAction menuAction) {
		this.menuAction = menuAction;
	}
	
	public MenuAction getMenuAction() {
		return menuAction;
	}
}