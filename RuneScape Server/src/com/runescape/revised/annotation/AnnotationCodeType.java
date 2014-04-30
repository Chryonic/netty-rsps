package com.runescape.revised.annotation;

import com.runescape.revised.logic.mission.Mission;
import com.runescape.revised.logic.mission.impl.EditMission;
import com.runescape.revised.logic.mission.impl.FinishedMission;

public enum AnnotationCodeType {

    EDIT_CODE(new EditMission()),

    FINISHED_CODE(new FinishedMission());

    private Mission mission;

    private AnnotationCodeType(final Mission mission) {
            this.setMission(mission);
    }

    public void setMission(final Mission mission) {
            this.mission = mission;
    }

    public Mission getMission() {
            return this.mission;
    }
}