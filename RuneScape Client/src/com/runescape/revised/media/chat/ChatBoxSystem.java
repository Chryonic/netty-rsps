package com.runescape.revised.media.chat;

public class ChatBoxSystem {

	private ChatBox chatBox;

	public void addChatMessage(ChatMessage chatMessage) {
		this.getChatBox().getChatMessageQueue().add(chatMessage);
	}
	
	public void removeChatMessage(ChatMessage chatMessage) {
		this.getChatBox().getChatMessageQueue().remove(chatMessage);
	}
	
	public void removeChatMessages(ChatMessage chatMessage) {
		this.getChatBox().getChatMessageQueue().removeAll(this.getChatBox().getChatMessageQueue());
	}

	public ChatBox getChatBox() {
		return this.chatBox;
	}

	public void setChatBox(ChatBox chatBox) {
		this.chatBox = chatBox;
	}
}