# JAVA-Fun-Projects

This repo is made to learn and to have fun with Java. Making small projects and whatnot. Enjoy :)

A collection of small Java projects ranging from junior to medior level. Each project focuses on a set of core Java concepts and is accompanied by unit tests.

## Project Structure

```
src/
├── main/java/com/javaprojects/
│   ├── junior/
│   │   ├── fizzbuzz/         # FizzBuzz (Junior)
│   │   ├── calculator/       # Simple Calculator (Junior)
│   │   └── numbergame/       # Number Guessing Game (Junior)
│   └── medior/
│       ├── bankaccount/      # Bank Account (Medior)
│       └── studentmanager/   # Student Grade Manager (Medior)
└── test/java/com/javaprojects/  # JUnit 5 tests for each project
```

## Projects

### 🟢 Junior Level

#### FizzBuzz
The classic programming challenge. For numbers 1–N:
- Print **Fizz** for multiples of 3
- Print **Buzz** for multiples of 5
- Print **FizzBuzz** for multiples of both 3 and 5
- Otherwise print the number

**Concepts:** Loops, conditionals, modulo operator

---

#### Simple Calculator
A calculator supporting addition, subtraction, multiplication, division, and modulo.

**Concepts:** Methods, arithmetic operators, exception handling (`ArithmeticException` for divide by zero)

---

#### Number Guessing Game
An interactive console game where the player tries to guess a randomly generated number within a range. Provides "Too low" / "Too high" hints.

**Concepts:** `Random`, `Scanner`, loops, conditionals

---

### 🟡 Medior Level

#### Bank Account
Models a bank account with deposit, withdrawal, and transfer operations.

**Concepts:** Encapsulation (private fields + getters), custom exceptions (`InsufficientFundsException`), input validation

---

#### Student Grade Manager
Manages a collection of students and their grades. Supports ranking, filtering, averaging, and grouping by letter grade.

**Concepts:** Collections (`List`, `Map`), Java Streams, lambdas, `Optional`, `Collectors.groupingBy`

---

## Getting Started

### Prerequisites
- Java 11+
- Maven 3.6+

### Build & Test

```bash
mvn test
```

### Run a specific project

```bash
# Compile first
mvn compile

# Run FizzBuzz
mvn exec:java -Dexec.mainClass="com.javaprojects.junior.fizzbuzz.FizzBuzz"

# Run Calculator demo
mvn exec:java -Dexec.mainClass="com.javaprojects.junior.calculator.Calculator"

# Run Number Guessing Game
mvn exec:java -Dexec.mainClass="com.javaprojects.junior.numbergame.NumberGuessingGame"

# Run Bank Account demo
mvn exec:java -Dexec.mainClass="com.javaprojects.medior.bankaccount.BankAccount"

# Run Student Grade Manager demo
mvn exec:java -Dexec.mainClass="com.javaprojects.medior.studentmanager.StudentGradeManager"
```
