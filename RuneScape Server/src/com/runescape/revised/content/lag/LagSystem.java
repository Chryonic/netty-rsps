package com.runescape.revised.content.lag;

import com.runescape.revised.system.System;

public class LagSystem extends System {

	private static LagSystem lagSystem;
	
	public static void setLagSystem(LagSystem lagSystem) {
		LagSystem.lagSystem = lagSystem;
	}
	
	public static LagSystem getLagSystem() {
		return LagSystem.lagSystem;
	}
}