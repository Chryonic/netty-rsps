package com.runescape.revised.media.chat;

public class ChatMessage {

	private String message;
	private ChatColor chatColor;
	private ChatEffect chatEffect;
	
	public ChatMessage(String message, ChatColor chatColor, ChatEffect chatEffect) {
		this.setMessage(message);
		this.setChatColor(chatColor);
		this.setChatEffect(chatEffect);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

	public void setChatColor(ChatColor chatColor) {
		this.chatColor = chatColor;
	}
	
	public ChatColor getChatColor() {
		return this.chatColor;
	}
	
	public void setChatEffect(ChatEffect chatEffect) {
		this.chatEffect = chatEffect;
	}
	
	public ChatEffect getChatEffect() {
		return this.chatEffect;
	}
}