package com.fortebank.forteidea.exceptions;

public class DataNotFoundException extends RuntimeException {
    private String field;
    public DataNotFoundException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
