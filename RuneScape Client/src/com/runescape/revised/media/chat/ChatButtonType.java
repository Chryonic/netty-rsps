package com.runescape.revised.media.chat;

public enum ChatButtonType {

	PUBLIC, PRIVATE, TRADE_DUEL;
	
	private ChatButtonStatus chatButtonStatus;

	public void setChatButtonStatus(ChatButtonStatus chatButtonStatus) {
		this.chatButtonStatus = chatButtonStatus;
	}

	public ChatButtonStatus getChatButtonStatus() {
		return this.chatButtonStatus;
	}
}