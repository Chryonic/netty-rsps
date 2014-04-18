package com.runescape.revised.model;

public class RenderSystem {

	private static RenderSystem renderSystem;

	public static void setRenderSystem(RenderSystem renderSystem) {
		RenderSystem.renderSystem = renderSystem;
	}

	public static RenderSystem getRenderSystem() {
		return RenderSystem.renderSystem;
	}
}