package com.dev.zkshowcase.exception;

/**
 * The Class ZkShowCaseException.
 */
public class ZkShowcaseException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new zk show case exception.
	 */
	public ZkShowcaseException() {
		super();
	}

	/**
	 * Instantiates a new zk show case exception.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ZkShowcaseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new zk show case exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ZkShowcaseException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new zk show case exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public ZkShowcaseException(Throwable cause) {
		super(cause);
	}

}
