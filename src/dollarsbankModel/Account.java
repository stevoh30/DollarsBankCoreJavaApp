package dollarsbankModel;

import java.util.Queue;

public abstract class Account {

    // Properties
    protected double balance;
    protected Queue<String> balanceHistory;

    // Constructor
    public Account(double balance, Queue<String> balanceHistory){
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

    public abstract void transactionHistory();

}
