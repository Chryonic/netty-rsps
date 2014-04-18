package com.runescape.revised.editor;

public class EditorSystem {

	private CacheEditor cacheEditor;
	private InterfaceEditor interfaceEditor;
	
	public void setCacheEditor(CacheEditor cacheEditor) {
		this.cacheEditor = cacheEditor;
	}
	
	public CacheEditor getCacheEditor() {
		return this.cacheEditor;
	}
	
	public void setInterfaceEditor(InterfaceEditor interfaceEditor) {
		this.interfaceEditor = interfaceEditor;
	}
	
	public InterfaceEditor getInterfaceEditor() {
		return this.interfaceEditor;
	}
}