package com.runescape.revised.client.newclient;

public class GameClient extends GameApplet {

	private static final long serialVersionUID = 1L;
	
	public GameClient() {
		new GameFrame(this);
	}
}