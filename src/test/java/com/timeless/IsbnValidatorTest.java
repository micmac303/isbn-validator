package com.timeless;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsbnValidatorTest {

    private final IsbnValidator isbnValidator = new IsbnValidator();

    @Test
    void shouldReturnFalseIfNotTenCharacters() {

        assertFalse(isbnValidator.validate("hello"));
    }

    @Test
    void shouldReturnTrueIfValid() {

        var validIsbn = "3598215088";
        var validIsbnX = "359821508X";

        assertTrue(isbnValidator.validate(validIsbn));
        assertTrue(isbnValidator.validate(validIsbnX));
    }

    @Test
    void shouldReturnFalseIfInvalid() {


    }
}