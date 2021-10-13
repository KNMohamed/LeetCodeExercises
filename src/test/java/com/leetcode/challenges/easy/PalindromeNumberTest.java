package com.leetcode.challenges.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeNumberTest {
    @Test
    void negativeNumberIsNotAPalindrome(){
        assertFalse(PalindromeNumber.isPalindrome(-121));
    }

    @Test
    void singleDigitNumberIsAPalindrome(){
        assertTrue(PalindromeNumber.isPalindrome(4));
    }

    @Test
    void positiveDoubleDigitNumberShouldReturnFalse(){
        assertFalse(PalindromeNumber.isPalindrome(45));
    }

    @Test
    void positiveDoubleDigitNumberShouldReturnTrue(){
        assertTrue(PalindromeNumber.isPalindrome(44));
    }

    @ParameterizedTest
    @ValueSource(ints = {454 ,6776 ,95459, 30455403})
    void validPalindromes(int x){
        assertTrue(PalindromeNumber.isPalindrome(x));
    }

    @ParameterizedTest
    @ValueSource(ints = {4542 ,673576 ,9459, 305403})
    void invalidPalindromes(int x){
        assertFalse(PalindromeNumber.isPalindrome(x));
    }

}
