package com.runescape.revised.media.tabarea.social.ignore;

import java.awt.Image;
import java.util.List;

import com.runescape.revised.media.tabarea.Tab;

public class IgnoreListTab extends Tab {

	private List<Ignore> ignoreList; // ArrayList

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

	public void setIgnoreList(final List<Ignore> ignoreList) {
		this.ignoreList = ignoreList;
	}

	public List<Ignore> getIgnoreList() {
		return this.ignoreList;
	}
}