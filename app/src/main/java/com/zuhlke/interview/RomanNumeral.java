package com.zuhlke.interview;

import java.util.HashMap;
import java.util.Map;

import com.zuhlke.interview.exception.*;

public class RomanNumeral {
    private int value;

    final Map<Character, Integer> matrix = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
        }
    };

    // I, II, III, IV, V, VI, VII, VIII, VIII, IX...

    RomanNumeral() {
        super();
    }

    RomanNumeral(String value) {
        super();
        valueOf(value);
    }

    public int getValue() {
        return this.value;
    }

    public void valueOf(String value) {
        this.value = parseToInteger(value);
    }

    public int parseToInteger(String value) {
        validateInput(value);

        // Calculate by basic for loop
        int result = 0;
        try {
            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                int val = matrix.get(c);
                if (i + 1 == value.length() ||
                        val >= matrix.get(value.charAt(i + 1))) {
                    result += val;
                } else {
                    result -= val;
                }
            }
        } catch (NullPointerException ex) {
            throw new IllegalRomanNumeralException(ex.getMessage());
        }

        return result;
    }

    private void validateInput(String romanNumeral) {
        if (null == romanNumeral || romanNumeral.trim().equals("")) {
            throw new EmptyRomanNumeralException();
        }
    }
}
