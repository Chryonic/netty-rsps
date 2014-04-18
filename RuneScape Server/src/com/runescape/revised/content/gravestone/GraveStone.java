package com.runescape.revised.content.gravestone;

import java.util.List;

import com.runescape.revised.content.item.Item;
import com.runescape.revised.logic.entity.npc.NPC;

public class GraveStone {

	private List<Item> itemList;
    private NPC graveNPC;
    private String owner;
    private String inscription;
    private int timeLeft;
    private GraveStoneState graveStoneState;
    
    public GraveStone() {
    	
    }

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Item> getItemList() {
		return this.itemList;
	}

	public void setGraveNPC(NPC graveNPC) {
		this.graveNPC = graveNPC;
	}

	public NPC getGraveNPC() {
		return this.graveNPC;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setInscription(String inscription) {
		this.inscription = inscription;
	}

	public String getInscription() {
		return this.inscription;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	public int getTimeLeft() {
		return this.timeLeft;
	}

	public void setGraveStoneState(GraveStoneState graveStoneState) {
		this.graveStoneState = graveStoneState;
	}

	public GraveStoneState getGraveStoneState() {
		return this.graveStoneState;
	}
}