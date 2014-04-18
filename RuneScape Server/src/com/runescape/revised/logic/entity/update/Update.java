package com.runescape.revised.logic.entity.update;

import com.runescape.revised.logic.entity.Entity;

public class Update {

	// represents an update
	private Entity entity;
	private UpdateMaskType updateMaskType;
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public Entity getEntity() {
		return this.entity;
	}
	
	public void setUpdateMaskType(UpdateMaskType updateMaskType) {
		this.updateMaskType = updateMaskType;
	}
	
	public UpdateMaskType getUpdateMaskType() {
		return this.updateMaskType;
	}
}