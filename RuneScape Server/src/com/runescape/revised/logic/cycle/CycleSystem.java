package com.runescape.revised.logic.cycle;

import com.runescape.revised.system.System;
import com.runescape.revised.annotation.AnnotationDesignType;
import com.runescape.revised.annotation.impl.DesignPattern;

@DesignPattern(getAnnotationDesignType = AnnotationDesignType.CREATIONAL)
public class CycleSystem extends System {

	private CycleQueue<Cycle> cycleList;
	private static CycleSystem cycleSystem;
	
	public CycleSystem() {
		this.setCycleList(new CycleQueue<Cycle>());
	}

	public void setCycleList(CycleQueue<Cycle> cycleList) {
		this.cycleList = cycleList;
	}

	public CycleQueue<Cycle> getCycleList() {
		return this.cycleList;
	}

	public static void setCycleSystem(CycleSystem cycleSystem) {
		CycleSystem.cycleSystem = cycleSystem;
	}

	public static CycleSystem getCycleSystem() {
		return CycleSystem.cycleSystem;
	}
}