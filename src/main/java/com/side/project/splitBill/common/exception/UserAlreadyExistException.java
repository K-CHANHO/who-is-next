package com.side.project.splitBill.common.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException() {
    }

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
