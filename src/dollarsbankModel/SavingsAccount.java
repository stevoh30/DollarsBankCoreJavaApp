package dollarsbankModel;

public class SavingsAccount extends Account{

    // Constructor
    public SavingsAccount(double balance, Double[] balanceHistory){
        super(balance, balanceHistory);
    }

    // Overridden Methods (Abstract)
    // Deposit if amount is greater than 0
    @Override
    public void deposit(double amount) {
        if(amount > 0){
            balance += amount;

            System.out.println("Amount of " + amount + " applied to account");
        }
        else{
            System.out.println("A negative amount cannot be deposited");
        }
    }

    // Withdraw function if amount is greater than 0 and
    // amount is less than balance
    @Override
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Amount of" + amount + " has been withdrawn");
        }
        else{
            System.out.println("Amount cannot be withdrawn from account");
        }
    }

    @Override
    public void transactionHistory(double previousBalance){
        if(balanceHistory.length < 5) {
            // add the previous balance into the double array;
        }
    }
}
