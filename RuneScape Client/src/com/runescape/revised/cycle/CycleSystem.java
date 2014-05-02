package com.runescape.revised.cycle;

import java.util.LinkedList;
import java.util.Queue;

import com.runescape.revised.System;
import com.runescape.revised.annotation.AnnotationDesignType;
import com.runescape.revised.annotation.impl.DesignPattern;

@DesignPattern(annotationDesignType = AnnotationDesignType.CREATIONAL)
public class CycleSystem extends System {

	private static CycleSystem cycleSystem;
	private Queue<Cycle> currentCycleList;
	private Queue<Cycle> newCycleList;

	public CycleSystem() {
		this.setCurrentCycleList(new LinkedList<Cycle>());
		this.setNewCycleList(new LinkedList<Cycle>());
	}

	public void addCycle(final Cycle cycle) {
		this.getCurrentCycleList().add(cycle);
		// this.getNewCycleList().
	}

	public static void setCycleSystem(final CycleSystem cycleSystem) {
		CycleSystem.cycleSystem = cycleSystem;
	}

	public static CycleSystem getCycleSystem() {
		if (CycleSystem.cycleSystem == null) {
			CycleSystem.setCycleSystem(new CycleSystem());
		}
		return CycleSystem.cycleSystem;
	}

	public void setCurrentCycleList(final Queue<Cycle> currentCycleList) {
		this.currentCycleList = currentCycleList;
	}

	public Queue<Cycle> getCurrentCycleList() {
		return this.currentCycleList;
	}

	public void setNewCycleList(final Queue<Cycle> newCycleList) {
		this.newCycleList = newCycleList;
	}

	public Queue<Cycle> getNewCycleList() {
		return this.newCycleList;
	}
}