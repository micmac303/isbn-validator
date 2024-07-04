package com.timeless;

public class IsbnValidator {

    public boolean validate(String isbn) {

        var isbnChars = isbn.chars();
        var numericalIsbn = isbnChars.mapToObj(c -> (char) c).filter(c -> c != '-')
                .filter(c -> Character.isDigit(c) || c == 'X')
                .map(c -> {
                    if (c == 'X') return 10;
                    else return Character.getNumericValue(c);
                })
                .toList();

        if (numericalIsbn.size() != 10) {
            return false;
        }

        System.out.println(numericalIsbn);

        return true;
    }
}
