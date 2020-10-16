package org.osi.swinerton.exception;

public class SwinException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SwinException(String message) {
		super(message);
	}

	public SwinException(Exception e) {
		super(e);
	}

}
