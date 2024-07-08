package com.timeless;

import java.util.stream.IntStream;

public class IsbnValidator {

    public boolean validate(String isbn) {

        //Return false if null
        if (isbn == null) return false;

        // Convert ISBN String to IntStream of char int values
        var isbnChars = isbn.chars();

        // Remove dashes and convert IntStream of char values to a list of actual numbers (Integers)
        // from the isbn. Changing X's to the number 10
        var numericalIsbn = isbnChars.mapToObj(c -> (char) c)
                .filter(c -> c != '-')
                .filter(c -> Character.isDigit(c) || c == 'X')
                .map(c -> {
                    if (c == 'X') return 10;
                    else return Character.getNumericValue(c);
                })
                .toList();

        // Return false if size is not 10 i.e. invalid size for ISBN-10
        if (numericalIsbn.size() != 10) return false;

        // From the last digit moving backwards, multiply each digit by its index, starting from 1
        int size = numericalIsbn.size();
        var sumOfCalculatedIsbn = IntStream.rangeClosed(1, size)
                .map(i -> numericalIsbn.get(size - i) * i)
                .sum();

        // Check if the number can be divided by 11 with no remainder if so return true otherwise return false
        return sumOfCalculatedIsbn % 11 == 0;
    }
}
