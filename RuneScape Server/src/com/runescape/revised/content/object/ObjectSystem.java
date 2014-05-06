package com.runescape.revised.content.object;

import com.runescape.revised.system.System;

public class ObjectSystem extends System {

	public static ObjectSystem objectSystem;

	public void loadObjects(final Object object) {
		;
	}

	@Override
	public void executeSystem() {

	}

	public static void setObjectSystem(final ObjectSystem objectSystem) {
		ObjectSystem.objectSystem = objectSystem;
	}

	public static ObjectSystem getObjectSystem() {
		return ObjectSystem.objectSystem;
	}
}