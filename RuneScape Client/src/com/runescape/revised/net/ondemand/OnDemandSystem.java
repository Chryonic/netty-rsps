package com.runescape.revised.net.ondemand;

public class OnDemandSystem {

	private static OnDemandSystem onDemandSystem;

	public static void setOnDemandSystem(OnDemandSystem onDemandSystem) {
		OnDemandSystem.onDemandSystem = onDemandSystem;
	}

	public static OnDemandSystem getOnDemandSystem() {
		return OnDemandSystem.onDemandSystem;
	}
}