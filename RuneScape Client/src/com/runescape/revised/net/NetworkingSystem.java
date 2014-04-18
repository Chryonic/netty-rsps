package com.runescape.revised.net;

import com.runescape.revised.net.netty.Netty;

public class NetworkingSystem {
	
	private static NetworkingSystem networkingSystem;

	public NetworkingSystem() {
		new Netty();
	}

	public static void setNetworkingSystem(NetworkingSystem networkingSystem) {
		NetworkingSystem.networkingSystem = networkingSystem;
	}

	public static NetworkingSystem getNetworkingSystem() {
		return NetworkingSystem.networkingSystem;
	}
}