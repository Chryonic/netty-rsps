package com.runescape;

// import com.runescape.revised.garbagecollector.GarbageCollector;
// import com.runescape.revised.logic.net.netty.Netty;
// import com.runescape.revised.logic.net.packets.Packet;
// import com.runescape.revised.server.GameServer;

public class Main {
	
	/**
	 * The main instance.
	 */
	private static Main main;
	
	/**
	 * The gameserver instance.
	 */
	// private GameServer gameServer;
	
	/**
	 * The packet instance.
	 */
	// private Packet[] packets;
	
	/**
	 * The main constructor.
	 */
	public Main() {
		// this.setGameServer();
		// new GarbageCollector();
		// new Netty();
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

	/** public void setGameServer(GameServer gameServer) {
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
	} */
}