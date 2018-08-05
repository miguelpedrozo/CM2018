package com.cm.misc.javeriana.game.app.exception;

/**
 * This class defines an exception used when the user's input to find
 * the secret number is invalid
 */
public class InputNotValidException extends Exception {
    public InputNotValidException() {
        super();
    }

    public InputNotValidException(String message) {
        super(message);
    }

    public InputNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputNotValidException(Throwable cause) {
        super(cause);
    }

    protected InputNotValidException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
