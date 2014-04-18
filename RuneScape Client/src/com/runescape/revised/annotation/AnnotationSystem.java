package com.runescape.revised.annotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.runescape.revised.annotation.AnnotationCodeType;
import com.runescape.revised.annotation.impl.Finished;

@Finished(getAnnotationType = AnnotationCodeType.FINISHED_CODE)
public class AnnotationSystem {
	
	public static void main(String[] args) {
		File directoryFile = new File("../Areto Server/src/com/");
		if (!directoryFile.exists()) {
			try {
				throw new FileNotFoundException("Directory does not exist: " + directoryFile);
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}
		}
		if (!directoryFile.isDirectory()) {
			throw new IllegalArgumentException("Is not a directory: " + directoryFile);
		}
		if (!directoryFile.canRead()) {
			try {
				throw new IllegalAccessException("Directory cannot be read: " + directoryFile);
			} catch (IllegalAccessException iae) {
				iae.printStackTrace();
			}
		}
		List<File> fileList = AnnotationSystem.getFileListing(directoryFile);
		Collections.sort(fileList);
		if (fileList == null) {
			return;
		}
		for (File file : fileList) {
			Class<?> classes = file.getClass();
			Annotation[] annotations = (Annotation[]) classes.getAnnotations();
			for (Annotation annotation : annotations) {
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
	
	public static List<File> getFileListing(File startingFile) {
		List<File> resultList = new ArrayList<File>();
		File[] files = startingFile.listFiles();
		List<File> fileDirectoryList = Arrays.asList(files);
		for (File file : fileDirectoryList) {
			if (file.getName().endsWith(".java")) {
				resultList.add(file);
			}
			if (!file.isFile()) {
				List<File> deeperFileList = AnnotationSystem.getFileListing(file);
				resultList.addAll(deeperFileList);
			}
		}
	 	return resultList;
	}
}