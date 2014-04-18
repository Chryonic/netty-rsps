package com.runescape.revised.model.entity;

public class EntitySystem {

	private static EntitySystem entitySystem;

	public static void setEntitySystem(EntitySystem entitySystem) {
		EntitySystem.entitySystem = entitySystem;
	}

	public static EntitySystem getEntitySystem() {
		return EntitySystem.entitySystem;
	}
}