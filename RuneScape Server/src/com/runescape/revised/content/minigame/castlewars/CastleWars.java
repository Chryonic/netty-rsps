package com.runescape.revised.content.minigame.castlewars;

import java.util.List;

import com.runescape.revised.content.minigame.MiniGame;
import com.runescape.revised.logic.entity.player.Player;

public class CastleWars extends MiniGame {

	private List<Player> playerList;

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public List<Player> getPlayerList() {
		return this.playerList;
	}
}