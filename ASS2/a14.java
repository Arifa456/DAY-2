package com.ASS2;

abstract class Account {
    private int accountNumber;
    private String accountHolder;
    protected double balance;
    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public abstract void withdraw(double amount);
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }
    public void transfer(Account targetAccount, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println(amount + " transferred to " + targetAccount.accountHolder);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }
    //Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance;
    }
}
//SavingsAccount
class SavingsAccount extends Account {
    private double minBalance = 500;
    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    //Override
    public void withdraw(double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Withdrawal denied! Minimum balance must be maintained.");
        }
    }
}
// Subclass: CurrentAccount
class CurrentAccount extends Account {
    public CurrentAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    //Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
// Main class
public class a14 {
    public static void main(String[] args) {
        Account savings = new SavingsAccount(105, "Vamsi", 5000);
        Account current = new CurrentAccount(100, "Anish", 8000);
        savings.deposit(1000);
        savings.withdraw(1800);
        savings.transfer(current, 2000);
        current.withdraw(1000);
        System.out.println("\nAccount Details:");
        System.out.println(savings);
        System.out.println(current);
    }
}
