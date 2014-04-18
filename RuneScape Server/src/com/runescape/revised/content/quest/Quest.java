package com.runescape.revised.content.quest;

public abstract class Quest {

	public abstract QuestCompletion getQuestCompletion();
	public abstract QuestLength getQuestLength();
	public abstract Difficulty getDifficulty();
	public abstract short getID();
	public abstract String getName();
	public abstract byte getQuestPointsGained();
}