package com.runescape.revised.content.quest;

import com.runescape.revised.system.System;

public class QuestSystem extends System {

	private static QuestSystem questSystem;
	private short questPoints;

	public static void setQuestSystem(QuestSystem questSystem) {
		QuestSystem.questSystem = questSystem;
	}

	public static QuestSystem getQuestSystem() {
		return QuestSystem.questSystem;
	}

	public void setQuestPoints(short questPoints) {
		this.questPoints = questPoints;
	}

	public short getQuestPoints() {
		return this.questPoints;
	}
}