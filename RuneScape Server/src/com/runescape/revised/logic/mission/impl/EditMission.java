package com.runescape.revised.logic.mission.impl;

import com.runescape.revised.annotation.AnnotationCodeType;
import com.runescape.revised.annotation.impl.Edit;
import com.runescape.revised.logic.mission.Mission;

@Edit(getAnnotationType = AnnotationCodeType.EDIT_CODE)
public class EditMission implements Mission {

        @Override
        public Object executeMission() {
                return null;
        }
}