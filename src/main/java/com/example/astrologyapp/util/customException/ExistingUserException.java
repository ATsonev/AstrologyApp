package com.example.astrologyapp.util.customException;

public class ExistingUserException extends RuntimeException {
    public ExistingUserException(String message) {
        super(message);
    }
}
