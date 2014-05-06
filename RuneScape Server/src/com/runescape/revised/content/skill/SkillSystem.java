package com.runescape.revised.content.skill;

import java.util.Queue;

import com.runescape.revised.system.System;

public class SkillSystem extends System {

	private Queue<Skill> skillQueue;

	@Override
	public void executeSystem() {

	}

	public void setSkillQueue(final Queue<Skill> skillQueue) {
		this.skillQueue = skillQueue;
	}

	public Queue<Skill> getSkillQueue() {
		return this.skillQueue;
	}
}