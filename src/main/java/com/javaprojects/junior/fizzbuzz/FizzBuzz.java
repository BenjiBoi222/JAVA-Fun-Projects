package com.javaprojects.junior.fizzbuzz;

/**
 * FizzBuzz - Junior Level
 *
 * Classic programming challenge:
 * - Print "Fizz" for multiples of 3
 * - Print "Buzz" for multiples of 5
 * - Print "FizzBuzz" for multiples of both 3 and 5
 * - Otherwise print the number
 */
public class FizzBuzz {

    /**
     * Returns the FizzBuzz result for a given number.
     *
     * @param number the input number
     * @return "FizzBuzz", "Fizz", "Buzz", or the number as a String
     */
    public String evaluate(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }

    /**
     * Prints FizzBuzz results from 1 to the given limit (inclusive).
     *
     * @param limit the upper bound (inclusive)
     */
    public void printFizzBuzz(int limit) {
        for (int i = 1; i <= limit; i++) {
            System.out.println(evaluate(i));
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println("FizzBuzz from 1 to 20:");
        fizzBuzz.printFizzBuzz(20);
    }
}
