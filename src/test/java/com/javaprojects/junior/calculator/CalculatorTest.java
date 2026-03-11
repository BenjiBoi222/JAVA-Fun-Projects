package com.javaprojects.junior.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void add_twoPositiveNumbers_returnsSum() {
        assertEquals(15.0, calculator.add(10, 5));
    }

    @Test
    void add_negativeNumbers_returnsSum() {
        assertEquals(-3.0, calculator.add(-1, -2));
    }

    @Test
    void subtract_twoPositiveNumbers_returnsDifference() {
        assertEquals(5.0, calculator.subtract(10, 5));
    }

    @Test
    void subtract_resultIsNegative_returnsDifference() {
        assertEquals(-5.0, calculator.subtract(5, 10));
    }

    @Test
    void multiply_twoPositiveNumbers_returnsProduct() {
        assertEquals(50.0, calculator.multiply(10, 5));
    }

    @Test
    void multiply_byZero_returnsZero() {
        assertEquals(0.0, calculator.multiply(10, 0));
    }

    @Test
    void multiply_twoNegativeNumbers_returnsPositive() {
        assertEquals(6.0, calculator.multiply(-2, -3));
    }

    @Test
    void divide_twoPositiveNumbers_returnsQuotient() {
        assertEquals(2.0, calculator.divide(10, 5));
    }

    @Test
    void divide_byZero_throwsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }

    @Test
    void modulo_returnsRemainder() {
        assertEquals(1.0, calculator.modulo(10, 3));
    }

    @Test
    void modulo_byZero_throwsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> calculator.modulo(10, 0));
    }

    @Test
    void divide_negativeByPositive_returnsNegativeQuotient() {
        assertEquals(-2.0, calculator.divide(-10, 5));
    }
}
