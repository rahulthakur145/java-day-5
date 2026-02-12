package casestudy4;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        bank.createAccount("101", "Rahul", 10000);
        bank.createAccount("102", "Amit", 5000);

        Account acc1 = bank.getAccount("101");
        Account acc2 = bank.getAccount("102");

        try {
            acc1.deposit(2000);
            acc1.withdraw(3000);
            acc1.transfer(acc2, 4000);
            acc1.withdraw(20000);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nAll Accounts Details:");
        bank.displayAllAccounts();
    }
}

