package com.runescape.revised.content.object;

import com.runescape.revised.content.object.Object;
// import com.runescape.revised.object.impl.Dummy;
import com.runescape.revised.system.System;

public class ObjectSystem extends System {

	public static ObjectSystem objectSystem;
	
	public void loadObjects(Object object) {
		;
	}
	
	public static void setObjectSystem(ObjectSystem objectSystem) {
		ObjectSystem.objectSystem = objectSystem;
	}
	
	public static ObjectSystem getObjectSystem() {
		return ObjectSystem.objectSystem;
	}
}