package com.webtoonvote.exception;

public class StorageException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7215162432826208282L;

	public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}