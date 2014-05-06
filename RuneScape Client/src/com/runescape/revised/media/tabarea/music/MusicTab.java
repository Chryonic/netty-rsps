package com.runescape.revised.media.tabarea.music;

import java.awt.Image;
import java.util.List;

import com.runescape.revised.media.tabarea.Tab;

public class MusicTab extends Tab {

	private List<Song> musicList; // ArrayList

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

	public void setMusicList(final List<Song> musicList) {
		this.musicList = musicList;
	}

	public List<Song> getMusicList() {
		return this.musicList;
	}
}