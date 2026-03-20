package casestudy7;

abstract class Payment {
    String id;

    Payment(String id) {
        this.id = id;
    }

    abstract double processPayment(double amount);
}

class CreditCardPayment extends Payment {
    String cardNumber;

    CreditCardPayment(String id, String cardNumber) {
        super(id);
        this.cardNumber = cardNumber;
    }

    @Override
    double processPayment(double amount) {
        double finalAmount = amount + (amount * 0.02);
        System.out.println("Credit Card [" + cardNumber + "] Payment: " + finalAmount);
        return finalAmount;
    }
}

class UPIPayment extends Payment {
    String upiId;

    UPIPayment(String id, String upiId) {
        super(id);
        this.upiId = upiId;
    }

    @Override
    double processPayment(double amount) {
        System.out.println("UPI [" + upiId + "] Payment: " + amount);
        return amount;
    }
}

class PaymentProcessor {

    void processPaymentChoice(int choice, double amount) {
        Payment p;

        if (choice == 1) {
            p = new CreditCardPayment("P101", "1234-5678-9012-3456");
        } else if (choice == 2) {
            p = new UPIPayment("P102", "user@upi");
        } else {
            System.out.println("Invalid choice");
            return;
        }

        p.processPayment(amount);
    }

    double processBothPayments(double amount) {
        Payment card = new CreditCardPayment("P201", "1234-5678-9012-3456");
        Payment upi = new UPIPayment("P202", "user@upi");

        double cardAmount = card.processPayment(amount);
        double upiAmount = upi.processPayment(amount);

        double total = cardAmount + upiAmount;

        System.out.println("Total after both payments: " + total);
        return total;
    }
}

public class case_1 {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        processor.processPaymentChoice(1, 1000);
        processor.processPaymentChoice(2, 500);

        processor.processBothPayments(1000);
    }
}