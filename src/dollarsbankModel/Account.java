package dollarsbankModel;

public abstract class Account {

    // Properties
    protected double balance;
    protected Double[] balanceHistory = new Double[5];


    // Constructor
    public Account(double balance, Double[] balanceHistory){
        this.balance = balance;
        this.balanceHistory = balanceHistory;
    }

    // Getter Method
    public double getBalance() {
        return balance;
    }

    // Abstract Methods
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void transactionHistory(double balanceHistory);

}
