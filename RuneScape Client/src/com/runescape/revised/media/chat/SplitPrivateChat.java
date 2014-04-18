package com.runescape.revised.media.chat;

import java.util.Queue;

public class SplitPrivateChat {

	private Queue<ChatMessage> chatMessageQueue;
	
	public SplitPrivateChat() {
		this.getChatMessageQueue().clear();
	}
	
	public void removeChatMessage(ChatMessage chatMessage) {
		this.getChatMessageQueue().remove(chatMessage);
	}

	public void setChatMessage(Queue<ChatMessage> chatMessageQueue) {
		this.chatMessageQueue = chatMessageQueue;
	}

	public Queue<ChatMessage> getChatMessageQueue() {
		return this.chatMessageQueue;
	}
}