package com.runescape.revised.cycle;

import com.runescape.revised.System;
import com.runescape.revised.annotation.AnnotationDesignType;
import com.runescape.revised.annotation.impl.DesignPattern;

@DesignPattern(annotationDesignType = AnnotationDesignType.CREATIONAL)
public class CycleSystem extends System {

	private CycleList<Cycle> cycleList;
	private static CycleSystem cycleSystem;
	
	public CycleSystem(Cycle cycle, System system) {
		this.setCycleList(new CycleList<Cycle>());
	}

	public void setCycleList(CycleList<Cycle> cycleList) {
		this.cycleList = cycleList;
	}

	public CycleList<Cycle> getCycleList() {
		return this.cycleList;
	}

	public static void setCycleSystem(CycleSystem cycleSystem) {
		CycleSystem.cycleSystem = cycleSystem;
	}

	public static CycleSystem getCycleSystem() {
		return CycleSystem.cycleSystem;
	}
}