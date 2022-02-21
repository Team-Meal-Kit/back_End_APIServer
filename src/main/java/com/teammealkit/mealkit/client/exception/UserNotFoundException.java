package com.teammealkit.mealkit.client.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super(email + " NotFoundException");
    }
}
