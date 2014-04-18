package com.runescape.revised.logic.mission;

import com.runescape.revised.annotation.AnnotationCodeType;
import com.runescape.revised.annotation.impl.Finished;


@Finished(getAnnotationType = AnnotationCodeType.FINISHED_CODE)
// @DesignPattern(getAnnotationDesignType = AnnotationDesignType.)
public interface Mission {

	public Object executeMission();
}