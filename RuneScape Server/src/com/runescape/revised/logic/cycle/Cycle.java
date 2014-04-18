package com.runescape.revised.logic.cycle;

import com.runescape.revised.logic.Logic;
import com.runescape.revised.logic.mission.Mission;

public abstract class Cycle extends Logic {

	private short cycleTime;
	private System system;
	private Mission mission;
	
	public Cycle(short cycleTime) {
		this.setCycleTime(cycleTime);
	}
	
	public abstract void startCycle();
	
	public void setCycleTime(short cycleTime) {
		this.cycleTime = cycleTime;
	}
	
	public short getCycleTime() {
		return this.cycleTime;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public System getSystem() {
		return this.system;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Mission getMission() {
		return this.mission;
	}
}