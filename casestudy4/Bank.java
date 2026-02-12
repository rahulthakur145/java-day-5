package casestudy4;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<Account>();
    }

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        Account account = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in bank.");
        } else {
            for (Account acc : accounts) {
                acc.displayAccountDetails();
            }
        }
    }
}
