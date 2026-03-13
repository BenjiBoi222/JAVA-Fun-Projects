package com.javaprojects.junior.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void evaluate_multipleOfThree_returnsFizz() {
        assertEquals("Fizz", fizzBuzz.evaluate(3));
        assertEquals("Fizz", fizzBuzz.evaluate(6));
        assertEquals("Fizz", fizzBuzz.evaluate(9));
    }

    @Test
    void evaluate_multipleOfFive_returnsBuzz() {
        assertEquals("Buzz", fizzBuzz.evaluate(5));
        assertEquals("Buzz", fizzBuzz.evaluate(10));
        assertEquals("Buzz", fizzBuzz.evaluate(20));
    }

    @Test
    void evaluate_multipleOfFifteen_returnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(15));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(30));
        assertEquals("FizzBuzz", fizzBuzz.evaluate(45));
    }

    @Test
    void evaluate_notMultipleOfThreeOrFive_returnsNumber() {
        assertEquals("1", fizzBuzz.evaluate(1));
        assertEquals("2", fizzBuzz.evaluate(2));
        assertEquals("7", fizzBuzz.evaluate(7));
        assertEquals("11", fizzBuzz.evaluate(11));
    }

    @Test
    void evaluate_negativeMultipleOfThree_returnsFizz() {
        assertEquals("Fizz", fizzBuzz.evaluate(-3));
        assertEquals("Fizz", fizzBuzz.evaluate(-9));
    }

    @Test
    void evaluate_negativeMultipleOfFive_returnsBuzz() {
        assertEquals("Buzz", fizzBuzz.evaluate(-5));
        assertEquals("Buzz", fizzBuzz.evaluate(-10));
    }

    @Test
    void evaluate_negativeMultipleOfFifteen_returnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(-15));
    }

    @Test
    void evaluate_zero_returnsFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.evaluate(0));
    }
}
