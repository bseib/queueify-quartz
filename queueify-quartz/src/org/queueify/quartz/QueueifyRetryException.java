package org.queueify.quartz;

public class QueueifyRetryException extends Exception {
	private static final long serialVersionUID = 1L;

	public QueueifyRetryException() {
	}

	public QueueifyRetryException(String message) {
		super(message);
	}

	public QueueifyRetryException(Throwable cause) {
		super(cause);
	}

	public QueueifyRetryException(String message, Throwable cause) {
		super(message, cause);
	}

}
