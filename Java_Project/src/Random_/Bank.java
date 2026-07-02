package Random_;
class bank {
    double bal;

    bank(double bal) {
        this.bal = bal;
    }

    void withdraw(double amt) throws InsufficientBalanceException {
        validate(amt);
        bal = bal - amt;
        System.out.println("Withdrawal successful. Balance = " + bal);
    }

    void validate(double amt) throws InsufficientBalanceException {
        if (bal < amt) {
            throw new InsufficientBalanceException("Withdrawal Failed!");
        }
    }
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

public class Bank {
    public static void main(String[] args) {
        bank b = new bank(50000);

        try {
            b.withdraw(20000);  // works
            b.withdraw(40000);  // throws exception
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Program continues normally!");
    }
}