package com.runescape.revised.model.entity.update.impl;

import com.runescape.revised.media.chat.ChatColor;
import com.runescape.revised.media.chat.ChatEffect;

public class Chat {

	private String text;
	private ChatEffect chatEffect;
	private ChatColor chatColor;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setChatEffect(ChatEffect chatEffect) {
		this.chatEffect = chatEffect;
	}
	
	public ChatEffect getChatEffect() {
		return chatEffect;
	}
	
	public void setChatColor(ChatColor chatColor) {
		this.chatColor = chatColor;
	}
	
	public ChatColor getChatColor() {
		return chatColor;
	}
}