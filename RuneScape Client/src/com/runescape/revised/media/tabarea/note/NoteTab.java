package com.runescape.revised.media.tabarea.note;

import java.awt.Image;
import java.util.List;

import com.runescape.revised.media.tabarea.Tab;

public class NoteTab extends Tab {

	private List<Note> noteList; // ArrayList

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

	public void setNoteList(final List<Note> noteList) {
		this.noteList = noteList;
	}

	public List<Note> getNoteList() {
		return this.noteList;
	}
}