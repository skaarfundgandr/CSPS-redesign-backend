package org.csps.backend.exception;

public class InvalidStudentId extends RuntimeException{
    public InvalidStudentId(String message) {
        super(message);
    }
}
