public class Customer {
    private double balance=5000;

    public double getBalance() {
        return balance;
    }
    public boolean canAfford(double amount) {
        return balance >= amount;
    }

    public void deduct(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance ");
        }
        balance -= amount;
    }
}