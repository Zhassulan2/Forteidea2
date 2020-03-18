package com.fortebank.forteidea.exceptions;

public class DataNotFilledException extends Exception {
    private String field;

    public DataNotFilledException(String message, String field) {
//        String message = "Incoming item not defined: " + field;
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
