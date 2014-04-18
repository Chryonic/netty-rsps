package com.runescape.revised.annotation;

public class AnnotationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AnnotationException() {
		super();
	}
	
	public AnnotationException(String message) {
		super(message);
	}
	
	public AnnotationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AnnotationException(Throwable cause) {
		super(cause);
	}
}