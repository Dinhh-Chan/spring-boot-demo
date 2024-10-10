package com.example.demo.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User already exists");

    private final int code;
    private final String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
