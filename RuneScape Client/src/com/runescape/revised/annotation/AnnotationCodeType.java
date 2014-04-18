package com.runescape.revised.annotation;

import com.runescape.revised.mission.Mission;
import com.runescape.revised.mission.impl.EditMission;
import com.runescape.revised.mission.impl.FinishedMission;


public enum AnnotationCodeType {

    EDIT_CODE(new EditMission()),

    FINISHED_CODE(new FinishedMission());

    private Mission task;

    private AnnotationCodeType(Mission task) {
            this.setTask(task);
    }

    public void setTask(Mission task) {
            this.task = task;
    }

    public Mission getTask() {
            return this.task;
    }
}