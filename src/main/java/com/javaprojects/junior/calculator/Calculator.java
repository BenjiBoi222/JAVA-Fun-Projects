package com.javaprojects.junior.calculator;

/**
 * SimpleCalculator - Junior Level
 *
 * Demonstrates basic arithmetic operations and handling of edge cases
 * such as division by zero.
 */
public class Calculator {

    /**
     * Adds two numbers.
     *
     * @param a first operand
     * @param b second operand
     * @return the sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     *
     * @param a first operand
     * @param b second operand
     * @return the difference a - b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a first operand
     * @param b second operand
     * @return the product of a and b
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the quotient a / b
     * @throws ArithmeticException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    /**
     * Returns the remainder (modulo) of dividing the first number by the second.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the remainder a % b
     * @throws ArithmeticException if b is zero
     */
    public double modulo(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a % b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Simple Calculator Demo");
        System.out.println("10 + 5  = " + calc.add(10, 5));
        System.out.println("10 - 5  = " + calc.subtract(10, 5));
        System.out.println("10 * 5  = " + calc.multiply(10, 5));
        System.out.println("10 / 5  = " + calc.divide(10, 5));
        System.out.println("10 % 3  = " + calc.modulo(10, 3));
    }
}
