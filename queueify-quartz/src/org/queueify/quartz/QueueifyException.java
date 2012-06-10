package org.queueify.quartz;

public class QueueifyException extends Exception {
	private static final long serialVersionUID = 1L;

	public QueueifyException() {
	}

	public QueueifyException(String message) {
		super(message);
	}

	public QueueifyException(Throwable cause) {
		super(cause);
	}

	public QueueifyException(String message, Throwable cause) {
		super(message, cause);
	}

}
