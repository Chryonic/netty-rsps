package com.runescape.revised.content.gravestone;

import com.runescape.revised.MemberType;
import com.runescape.revised.content.quest.Quest;

public enum GraveStoneType {

	MEMORIAL_PLAQUE, FLAG, SMALL_GRAVESTONE, ORNATE_GRAVESTONE, FONT_OF_LIFE,
	STELE, SYMBOL_OF_SARADOMIN, SYMBOL_OF_ZAMORAK, SYMBOL_OF_GUTHIX,
	SYMBOL_OF_BANDOS, SYMBOL_OF_ARMADYL, ZAROS_ANCIENT_SYMBOL, ANGEL_OF_DEATH,
	ROYAL_DWARVEN_GRAVESTONE;

	private MemberType memberType;
	private int cost;
	private byte duration;
	private Quest questNeeded;
	private String text;
	
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	
	public MemberType getMemberType() {
		return memberType;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setDuration(byte duration) {
		this.duration = duration;
	}
	
	public byte getDuration() {
		return this.duration;
	}
	
	public void setQuestNeeded(Quest questNeeded) {
		this.questNeeded = questNeeded;
	}
	
	public Quest getQuestNeeded() {
		return this.questNeeded;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}