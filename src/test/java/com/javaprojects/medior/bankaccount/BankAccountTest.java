package com.javaprojects.medior.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount alice;
    private BankAccount bob;

    @BeforeEach
    void setUp() {
        alice = new BankAccount("ACC-001", "Alice", 1000.00);
        bob = new BankAccount("ACC-002", "Bob", 500.00);
    }

    @Test
    void constructor_validArguments_createsAccount() {
        assertEquals("ACC-001", alice.getAccountNumber());
        assertEquals("Alice", alice.getOwnerName());
        assertEquals(1000.00, alice.getBalance());
    }

    @Test
    void constructor_negativeInitialBalance_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("ACC-003", "Charlie", -100));
    }

    @Test
    void constructor_blankAccountNumber_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("", "Charlie", 100));
    }

    @Test
    void deposit_positiveAmount_increasesBalance() {
        alice.deposit(200.00);
        assertEquals(1200.00, alice.getBalance());
    }

    @Test
    void deposit_zeroAmount_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> alice.deposit(0));
    }

    @Test
    void deposit_negativeAmount_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> alice.deposit(-50));
    }

    @Test
    void withdraw_sufficientFunds_decreasesBalance() {
        alice.withdraw(300.00);
        assertEquals(700.00, alice.getBalance());
    }

    @Test
    void withdraw_exactBalance_setsBalanceToZero() {
        alice.withdraw(1000.00);
        assertEquals(0.00, alice.getBalance());
    }

    @Test
    void withdraw_insufficientFunds_throwsInsufficientFundsException() {
        assertThrows(InsufficientFundsException.class, () -> alice.withdraw(1500.00));
    }

    @Test
    void withdraw_negativeAmount_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> alice.withdraw(-100));
    }

    @Test
    void transfer_validAmount_updatesBalances() {
        alice.transfer(bob, 250.00);
        assertEquals(750.00, alice.getBalance());
        assertEquals(750.00, bob.getBalance());
    }

    @Test
    void transfer_insufficientFunds_throwsInsufficientFundsException() {
        assertThrows(InsufficientFundsException.class, () -> alice.transfer(bob, 2000.00));
        // balances should remain unchanged
        assertEquals(1000.00, alice.getBalance());
        assertEquals(500.00, bob.getBalance());
    }
}
