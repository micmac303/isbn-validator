package com.timeless;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsbnValidatorTest {

    private final IsbnValidator isbnValidator = new IsbnValidator();

    @Test
    void shouldReturnFalseIfNotTenCharacters() {

        var invalidIsbn = "notTenCharacters";
        assertFalse(isbnValidator.validate(invalidIsbn));
    }

    @Test
    void shouldReturnTrueIfValid() {

        var validIsbn = "3-598-21500-2";
        assertTrue(isbnValidator.validate(validIsbn));
    }

    @Test
    void shouldReturnFalseIfInvalid() {

        var invalidIsbn = "3-598-21508-9";
        assertFalse(isbnValidator.validate(invalidIsbn));
    }

    @Test
    void shouldReturnTrueIfValidX() {

        var validIsbnX = "0-8044-2957-X";
        assertTrue(isbnValidator.validate(validIsbnX));
    }
}
