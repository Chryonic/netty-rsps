package com.runescape.revised.menu;

import java.awt.Graphics;

public class Menu {
	
	private MenuList menuList;
	
	public Menu (Graphics graphics) {
		// graphics.drawImage
	}
	
	public Menu(short[] ids, String[] names, MenuAction[] menuActions) {
		for (int i = 0; i < ids.length; i++) {
			this.getMenuList().add(ids[i], names[i], menuActions[i]);
		}
	}

	public void setMenuList(MenuList menuList) {
		this.menuList = menuList;
	}

	public MenuList getMenuList() {
		return this.menuList;
	}
	
	/** public void setIDs(short[] ids) {
		this.ids = ids;
	}

	public short[] getIDs() {
		return this.ids;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String[] getNames() {
		return this.names;
	}

	public void setMenuActions(MenuAction[] menuActions) {
		this.menuActions = menuActions;
	}

	public MenuAction[] getMenuActions() {
		return this.menuActions;
	} */
}