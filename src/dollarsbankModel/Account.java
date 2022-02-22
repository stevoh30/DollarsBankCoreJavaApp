package dollarsbankModel;

public abstract class Account {

    // Properties
    public double balance;

    // Constructor
    public Account(double balance){
        this.balance = balance;
    }

    // Getter Method
    public double getBalance() {
        return balance;
    }

    // Abstract Methods
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

}
