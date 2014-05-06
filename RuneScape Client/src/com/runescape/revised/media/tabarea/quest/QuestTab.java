package com.runescape.revised.media.tabarea.quest;

import java.awt.Image;
import java.util.List;

import com.runescape.revised.media.tabarea.Tab;

public class QuestTab extends Tab {

	private List<Quest> questList; // ArrayList since we can create new Quests

	@Override
	public int getInterfaceID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Image getClickedImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setQuestList(final List<Quest> questList) {
		this.questList = questList;
	}

	public List<Quest> getQuestList() {
		return this.questList;
	}
}