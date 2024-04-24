package com.side.project.splitBill.common.exception;

public class NeedAuthenticationException extends RuntimeException{

    public NeedAuthenticationException() {
        super();
    }

    public NeedAuthenticationException(String message) {
        super(message);
    }
}
