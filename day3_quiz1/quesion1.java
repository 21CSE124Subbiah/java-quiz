package day3_quiz1;

import java.util.Scanner;

class BankAccount {
    private static int accountIdCounter = 12344;

    private int accountId;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountId = ++accountIdCounter;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void transferTo(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;

            System.out.println("Receipt: " +
                    "\nAccount ID: " + accountId +
                    "\nName: " + accountHolderName +
                    "\nTransferred Rs." + amount + " to Account ID: " + recipient.accountId +
                    "\nUpdated Account Balance: Rs." + balance + "\n");
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
}

public class quesion1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance for Account A: ");
        double initialBalanceA = scanner.nextDouble();
        BankAccount accountA = new BankAccount("Account A", initialBalanceA);

        System.out.print("Enter initial balance for Account B: ");
        double initialBalanceB = scanner.nextDouble();
        BankAccount accountB = new BankAccount("Account B", initialBalanceB);

        System.out.println("Initial Account Details:\n");
        accountA.transferTo(accountB, 1500);
        accountB.transferTo(accountA, 3000);

        scanner.close();
    }
}
