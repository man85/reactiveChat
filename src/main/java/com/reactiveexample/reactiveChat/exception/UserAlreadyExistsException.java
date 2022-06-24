package com.reactiveexample.reactiveChat.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(final String username) {
        super("User \"" + username + "\" already exists");
    }
}
