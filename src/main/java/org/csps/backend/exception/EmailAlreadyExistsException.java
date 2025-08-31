package org.csps.backend.exception;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("User with the email " + email + " already exists");
    }
}
