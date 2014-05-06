package com.runescape.revised.media.tabarea.social.friend;

import java.awt.Image;
import java.util.List;

import com.runescape.revised.media.tabarea.Tab;

public class FriendListTab extends Tab {

	private List<Friend> friendList;

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

	public void setFriendList(final List<Friend> friendList) {
		this.friendList = friendList;
	}

	public List<Friend> getFriendList() {
		return this.friendList;
	}
}