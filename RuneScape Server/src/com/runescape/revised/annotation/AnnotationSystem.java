package com.runescape.revised.annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.runescape.revised.annotation.impl.Finished;
import com.runescape.revised.system.System;

@Finished(getAnnotationType = AnnotationCodeType.FINISHED_CODE)
public class AnnotationSystem extends System {

	private static AnnotationSystem annotationSystem;

	public static void main(final String[] args) {
		final File directoryFile = new File("../RuneScape Server/src/com/");
		if (!directoryFile.exists()) {
			try {
				throw new FileNotFoundException("Directory does not exist: " + directoryFile);
			} catch (final FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}
		}
		if (!directoryFile.isDirectory()) {
			throw new IllegalArgumentException("Is not a directory: " + directoryFile);
		}
		if (!directoryFile.canRead()) {
			try {
				throw new IllegalAccessException("Directory cannot be read: " + directoryFile);
			} catch (final IllegalAccessException iae) {
				iae.printStackTrace();
			}
		}
		final List<File> fileList = AnnotationSystem.getFileListing(directoryFile);
		Collections.sort(fileList);
		if (fileList == null) {
			return;
		}
		for (final File file : fileList) {
			Class<?> classes = file.getClass();
			final Annotation[] annotations = (Annotation[]) classes.getAnnotations();
			for (final Annotation annotation : annotations) {
				if (((java.lang.annotation.Annotation) annotation).annotationType().equals("Finished")) {
					classes = null;
					/**
					 * Make it so that you store the original files into a Map or a List
					 * and simply check if it has been changed.
					 */
				}
			}
		}
	}

	@Override
	public void executeSystem() {}

	public static List<File> getFileListing(final File startingFile) {
		final List<File> resultList = new ArrayList<File>();
		final File[] files = startingFile.listFiles();
		final List<File> fileDirectoryList = Arrays.asList(files);
		for (final File file : fileDirectoryList) {
			if (file.getName().endsWith(".java")) {
				resultList.add(file);
			}
			if (!file.isFile()) {
				final List<File> deeperFileList = AnnotationSystem.getFileListing(file);
				resultList.addAll(deeperFileList);
			}
		}
		return resultList;
	}

	public static void setAnnotationSystem(final AnnotationSystem annotationSystem) {
		AnnotationSystem.annotationSystem = annotationSystem;
	}

	public static AnnotationSystem getAnnotationSystem() {
		return AnnotationSystem.annotationSystem;
	}
}