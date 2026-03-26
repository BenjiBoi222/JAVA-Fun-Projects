package com.javaprojects.medior.bankaccount;

/**
 * BankAccount - Medior Level
 *
 * Demonstrates Object-Oriented Programming principles:
 * - Encapsulation (private fields with getters/setters)
 * - Custom exceptions for domain-specific errors
 * - Business logic validation (insufficient funds, negative amounts)
 */
public class BankAccount {

    private final String accountNumber;
    private final String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be blank.");
        }
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name cannot be blank.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Deposits a positive amount into the account.
     *
     * @param amount the amount to deposit
     * @throws IllegalArgumentException if the amount is not positive
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    /**
     * Withdraws a positive amount from the account.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is not positive
     * @throws InsufficientFundsException if the balance is insufficient
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    String.format("Insufficient funds. Balance: %.2f, Requested: %.2f", balance, amount));
        }
        balance -= amount;
    }

    /**
     * Transfers a positive amount to another BankAccount.
     *
     * @param target the destination account
     * @param amount the amount to transfer
     */
    public void transfer(BankAccount target, double amount) {
        this.withdraw(amount);
        target.deposit(amount);
    }

    @Override
    public String toString() {
        return String.format("BankAccount[account=%s, owner=%s, balance=%.2f]",
                accountNumber, ownerName, balance);
    }

    public static void main(String[] args) {
        BankAccount alice = new BankAccount("ACC-001", "Alice", 1000.00);
        BankAccount bob = new BankAccount("ACC-002", "Bob", 500.00);

        System.out.println("Before transfer:");
        System.out.println(alice);
        System.out.println(bob);

        alice.transfer(bob, 250.00);

        System.out.println("\nAfter Alice transfers 250 to Bob:");
        System.out.println(alice);
        System.out.println(bob);
    }
}
