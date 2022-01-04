package com.adhessit.rems.exception;

public class REMSException extends Exception {

    // read the book: Effective Java chap 11;
    private static final long serialVersionUID = 1L;

    public REMSException(String message) {
        super(message);
    }
}
