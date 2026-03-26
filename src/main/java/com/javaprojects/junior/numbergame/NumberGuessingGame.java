package com.javaprojects.junior.numbergame;

import java.util.Random;
import java.util.Scanner;

/**
 * NumberGuessingGame - Junior Level
 *
 * A simple number guessing game where the player tries to guess a randomly
 * generated number within a given range. Demonstrates:
 * - Random number generation
 * - Scanner for user input
 * - Loops and conditionals
 */
public class NumberGuessingGame {

    private final int minValue;
    private final int maxValue;
    private final int maxAttempts;
    private final Random random;

    public NumberGuessingGame(int minValue, int maxValue, int maxAttempts) {
        if (minValue >= maxValue) {
            throw new IllegalArgumentException("minValue must be less than maxValue.");
        }
        if (maxAttempts < 1) {
            throw new IllegalArgumentException("maxAttempts must be at least 1.");
        }
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxAttempts = maxAttempts;
        this.random = new Random();
    }

    /**
     * Generates a random target number within the configured range.
     *
     * @return a random integer in [minValue, maxValue]
     */
    public int generateTarget() {
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    /**
     * Checks the player's guess against the target number.
     *
     * @param guess  the player's guess
     * @param target the target number
     * @return a hint: "TOO_LOW", "TOO_HIGH", or "CORRECT"
     */
    public String checkGuess(int guess, int target) {
        if (guess < target) {
            return "TOO_LOW";
        } else if (guess > target) {
            return "TOO_HIGH";
        } else {
            return "CORRECT";
        }
    }

    /**
     * Runs the interactive guessing game in the console.
     */
    public void play() {
        int target = generateTarget();

        System.out.printf("Guess the number between %d and %d. You have %d attempts.%n",
                minValue, maxValue, maxAttempts);

        try (Scanner scanner = new Scanner(System.in)) {
            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.printf("Attempt %d/%d: Enter your guess: ", attempt, maxAttempts);
                int guess = scanner.nextInt();
                String result = checkGuess(guess, target);

                switch (result) {
                    case "CORRECT":
                        System.out.printf("Correct! You guessed the number %d in %d attempt(s).%n", target, attempt);
                        return;
                    case "TOO_LOW":
                        System.out.println("Too low! Try higher.");
                        break;
                    case "TOO_HIGH":
                        System.out.println("Too high! Try lower.");
                        break;
                }
            }
        }
        System.out.printf("Game over! The number was %d.%n", target);
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame(1, 100, 7);
        game.play();
    }
}
