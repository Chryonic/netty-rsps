package com.runescape.revised.mission.impl;

import com.runescape.revised.annotation.AnnotationCodeType;
import com.runescape.revised.annotation.impl.Edit;
import com.runescape.revised.mission.Mission;


@Edit(getAnnotationType = AnnotationCodeType.EDIT_CODE)
public class FinishedMission implements Mission {

        @Override
        public Object executeTask() {
                return null;
        }
}