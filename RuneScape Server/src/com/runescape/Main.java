package com.runescape;

import com.runescape.revised.garbagecollector.GarbageCollector;
import com.runescape.revised.logic.net.netty.Netty;
import com.runescape.revised.server.GameServer;
import com.runescape.revised.server.SpawnServer;

public class Main {
	
	private GameServer gameServer;
	
	public Main() {
		this.setGameServer(new SpawnServer());
		new GarbageCollector();
		new Netty();
	}
	
	public static void main(String[] args) {
		new Main();
	}

	public void setGameServer(GameServer gameServer) {
		this.gameServer = gameServer;
	}

	public GameServer getGameServer() {
		return this.gameServer;
	}
}