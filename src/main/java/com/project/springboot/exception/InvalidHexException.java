package com.project.springboot.exception;

public class InvalidHexException extends RuntimeException {

    public InvalidHexException(String message) {
        super(message);
    }
}
