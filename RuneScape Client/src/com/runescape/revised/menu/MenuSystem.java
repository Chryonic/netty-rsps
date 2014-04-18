package com.runescape.revised.menu;

public class MenuSystem {

	private static MenuSystem menuSystem;
	
	public static void setMenuSystem(MenuSystem menuSystem) {
		MenuSystem.menuSystem = menuSystem;
	}
	
	public static MenuSystem getMenuSystem() {
		return MenuSystem.menuSystem;
	}
}