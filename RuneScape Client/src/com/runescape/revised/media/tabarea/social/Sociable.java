package com.runescape.revised.media.tabarea.social;

import com.runescape.revised.media.chat.ChatBox;

public interface Sociable {

	public boolean addConversation(ChatBox chatBox);
	public boolean removeConversation(ChatBox chatBox);
	public boolean addSocialist(Socialist socialist);
	public boolean removeSocialist(Socialist socialist);
}