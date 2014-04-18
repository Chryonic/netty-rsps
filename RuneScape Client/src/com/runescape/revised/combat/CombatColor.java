package com.runescape.revised.combat;

public enum CombatColor {

	RED("@red@"), ORANGE_THREE("@or3@"), ORANGE_TWO("@or2@"), ORANGE_ONE("@or1@"),
	GREEN("@gre@"), GREEN_THREE("@gre2@"), GREEN_TWO("@gre2@"),
	GREEN_ONE("@gre1@"), YELLOW("@yel@");
	
	private String colorText;
	
	CombatColor(String colorText) {
		this.setColorText(colorText);
	}
	
	public void setColorText(String colorText) {
		this.colorText = colorText;
	}
	
	public String getColorText() {
		return this.colorText;
	}
}