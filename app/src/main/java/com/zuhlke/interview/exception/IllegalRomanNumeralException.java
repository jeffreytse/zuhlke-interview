package com.zuhlke.interview.exception;

public class IllegalRomanNumeralException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public IllegalRomanNumeralException() {
        super("Illegal roman numeral with invalid characters");
    }

    public IllegalRomanNumeralException(String message) {
        super(message);
    }
}
