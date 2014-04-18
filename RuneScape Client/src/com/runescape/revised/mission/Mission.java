package com.runescape.revised.mission;

import com.runescape.revised.annotation.AnnotationCodeType;
import com.runescape.revised.annotation.impl.Finished;


@Finished(getAnnotationType = AnnotationCodeType.FINISHED_CODE)
public interface Mission {

	public Object executeTask();
}