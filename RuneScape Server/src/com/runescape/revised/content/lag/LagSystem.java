package com.runescape.revised.content.lag;

import com.runescape.revised.system.System;

public class LagSystem extends System {

	private static LagSystem lagSystem;

	@Override
	public void executeSystem() {

	}

	public static void setLagSystem(final LagSystem lagSystem) {
		LagSystem.lagSystem = lagSystem;
	}

	public static LagSystem getLagSystem() {
		return LagSystem.lagSystem;
	}
}