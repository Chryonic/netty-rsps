package com.runescape.revised.interfaces.impl.levelup;

import com.runescape.revised.Sprite;
import com.runescape.revised.interfaces.Button;
import com.runescape.revised.interfaces.Interface;
import com.runescape.revised.interfaces.Text;
import com.runescape.revised.media.threedworld.Location;

public class LevelAdvancement extends Interface {

	private SkillType skillType;

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sprite[] getSprites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location[] getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Button[] getButtons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Text[] getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}
}