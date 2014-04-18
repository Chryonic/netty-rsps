package com.runescape.revised.model;

public class ModelSystem {

	private static ModelSystem modelSystem;

	public static void setModelSystem(ModelSystem modelSystem) {
		ModelSystem.modelSystem = modelSystem;
	}

	public static ModelSystem getModelSystem() {
		return ModelSystem.modelSystem;
	}
}