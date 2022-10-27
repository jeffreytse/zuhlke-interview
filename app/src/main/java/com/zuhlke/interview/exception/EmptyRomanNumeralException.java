package com.zuhlke.interview.exception;

public class EmptyRomanNumeralException extends IllegalRomanNumeralException {
    public EmptyRomanNumeralException() {
        super("Input can't be empty");
    }

    public EmptyRomanNumeralException(String message) {
        super(message);
    }
}
