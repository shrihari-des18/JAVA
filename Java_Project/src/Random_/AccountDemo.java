package Random_;

import java.util.*;

class Account {
    int accNo;
    double balance;

    Account() {
    }

    Account(int accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accNo + ":" + balance;
    }

    void creditAmount(double amt) {
        balance += amt;
    }
}

public class AccountDemo {
    public static void main(String[] args) {

        ArrayList<Account> myAccounts = new ArrayList<Account>();

        // Add accounts to the list
        myAccounts.add(new Account(1001, 1000));
        myAccounts.add(new Account(1002, 2000));

        // Print all accounts (before credit)
        System.out.println("Before Credit:");
        for (Account a : myAccounts) {
            System.out.println(a);
        }

        // Credit 100 to each account
        System.out.println("\nAfter Credit:");
        for (Account a : myAccounts) {
            a.creditAmount(100);
            System.out.println(a);
        }
    }
}