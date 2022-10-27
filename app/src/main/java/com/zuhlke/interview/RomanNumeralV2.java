package com.zuhlke.interview;

import java.util.ArrayList;
import java.util.stream.IntStream;

import com.zuhlke.interview.exception.IllegalRomanNumeralException;

public class RomanNumeralV2 extends RomanNumeral {
    public RomanNumeralV2() {

    }

    public RomanNumeralV2(String value) {
        super(value);
    }

    @Override
    public int parseToInteger(String value) {
        validateInput(value);

        int result = IntStream.iterate(0, i -> i + 1)
                .limit(value.length())
                .mapToObj(i ->
                    // Transform to tuple object
                    new ArrayList<Character>() {
                        {
                            add(value.charAt(i));
                            add(i + 1 == value.length()
                                    ? null
                                    : value.charAt(i + 1));
                        }
                }).mapToInt(data -> {
                    // Calculate return value of tuple objects
                    int val = matrix.get(data.get(0));
                    int next = data.get(1) == null
                            ? 0
                            : matrix.getOrDefault(data.get(1), -1);

                    if (-1 == next) {
                        throw new IllegalRomanNumeralException();
                    }

                    if (val < next) {
                        return -1 * val;
                    }

                    return val;
                }).sum();

        return result;
    }
}
