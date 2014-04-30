package com.runescape.revised.annotation;

public class AnnotationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AnnotationException() {
		super();
	}
	
	public AnnotationException(final String message) {
		super(message);
	}
	
	public AnnotationException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	public AnnotationException(final Throwable cause) {
		super(cause);
	}
}