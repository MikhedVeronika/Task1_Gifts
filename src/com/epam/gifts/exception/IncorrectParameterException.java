package com.epam.gifts.exception;

public class IncorrectParameterException extends Exception {
    public IncorrectParameterException() {
    }

    public IncorrectParameterException(String message, Throwable exception) {
        super(message, exception);
    }

    public IncorrectParameterException(String message) {
        super(message);
    }

    public IncorrectParameterException(Throwable exception) {
        super(exception);
    }
}