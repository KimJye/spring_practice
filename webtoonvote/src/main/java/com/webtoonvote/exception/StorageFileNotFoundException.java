package com.webtoonvote.exception;

public class StorageFileNotFoundException extends StorageException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -752146831301319136L;

	public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}