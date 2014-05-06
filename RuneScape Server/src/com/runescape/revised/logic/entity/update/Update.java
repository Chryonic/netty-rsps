package com.runescape.revised.logic.entity.update;

import java.util.concurrent.RecursiveAction;

import com.runescape.revised.logic.entity.Entity;

public class Update extends RecursiveAction {

	/**
	 * The generated serial version.
	 */
	private static final long serialVersionUID = 1441770614588613604L;
	private Entity entity;
	private UpdateMaskType updateMaskType;

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		// add player and npc updating here
	}

	public void setEntity(final Entity entity) {
		this.entity = entity;
	}

	public Entity getEntity() {
		return this.entity;
	}

	public void setUpdateMaskType(final UpdateMaskType updateMaskType) {
		this.updateMaskType = updateMaskType;
	}

	public UpdateMaskType getUpdateMaskType() {
		return this.updateMaskType;
	}
}