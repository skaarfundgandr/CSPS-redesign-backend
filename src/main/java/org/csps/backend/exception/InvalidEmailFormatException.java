package org.csps.backend.exception;

public class InvalidEmailFormatException extends RuntimeException{

    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
