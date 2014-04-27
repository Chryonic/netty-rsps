package com.runescape;

import com.runescape.revised.garbagecollector.GarbageCollector;
import com.runescape.revised.logic.net.netty.Netty;
import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.server.GameServer;
import com.runescape.util.Timer;

public class Main {
	
	/**
	 * The main instance.
	 */
	private static Main main;
	
	/**
	 * The game server instance.
	 */
	private GameServer gameServer;
	
	/**
	 * The packet instance.
	 */
	private Packet[] packets;
	
	/**
	 * The constructor.
	 */
	public Main() {
		Timer timer = new Timer();
		new GarbageCollector();
		new Netty();
		System.out.println("RuneScape Server started in " + timer.toString());
	}
	
	public static void main(String[] args) {
		Main.getMain();
	}

	public static void setMain(Main main) {
		Main.main = main;
	}

	public static Main getMain() {
		if (Main.main == null) {
			Main.setMain(new Main());
		}
		return Main.main;
	}

	public void setGameServer(GameServer gameServer) {
		this.gameServer = gameServer;
	}

	public GameServer getGameServer() {
		return this.gameServer;
	}

	public void setPackets(Packet[] packets) {
		this.packets = packets;
	}

	public Packet[] getPackets() {
		return this.packets;
	}
}