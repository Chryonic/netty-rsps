package com.runescape.revised.media.clicking;

import com.runescape.revised.Sprite;

public enum ClickType {

	MODEL, WALK;
	
	private Sprite partOne;
	private Sprite partTwo;
	private Sprite partThree;
	
	public void setPartOne(Sprite partOne) {
		this.partOne = partOne;
	}
	
	public Sprite getPartOne() {
		return this.partOne;
	}
	
	public void setPartTwo(Sprite partTwo) {
		this.partTwo = partTwo;
	}
	
	public Sprite getPartTwo() {
		return this.partTwo;
	}
	
	public void setPartThree(Sprite partThree) {
		this.partThree = partThree;
	}
	
	public Sprite getPartThree() {
		return this.partThree;
	}
}