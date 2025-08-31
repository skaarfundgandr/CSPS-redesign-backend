package org.csps.backend.exception;

public class MissingFieldException extends RuntimeException{
    public MissingFieldException(String message) {
        super(message);
    }
}
