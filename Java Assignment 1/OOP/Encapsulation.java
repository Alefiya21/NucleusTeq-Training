//Explain the concept of encapsulation with a suitable example.
/*
Encapsulation is one of the four fundamental Object-Oriented Programming (OOP) principles. It refers to hiding the internal details of a class and restricting direct access to its data.
This is achieved using:
1. Private fields – Data members are declared private, preventing direct access from outside the class.
2. Public getter and setter methods – Provide controlled access to the private fields.
 */

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        System.out.println("Current balance: " + account.getBalance());

        account.deposit(500.0);
        System.out.println("Updated balance: " + account.getBalance()); 
    }
}
