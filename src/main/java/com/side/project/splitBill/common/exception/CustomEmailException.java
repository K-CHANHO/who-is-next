package com.side.project.splitBill.common.exception;

public class CustomEmailException extends RuntimeException{
    public CustomEmailException() {
    }

    public CustomEmailException(String message) {
        super(message);
    }
}
