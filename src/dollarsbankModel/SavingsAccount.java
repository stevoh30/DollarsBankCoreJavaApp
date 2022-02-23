package dollarsbankModel;

import java.util.Queue;

public class SavingsAccount extends Account{

    // Constructor
    public SavingsAccount(double balance, Queue<String> balanceHistory){
        super(balance, balanceHistory);
    }

    // Overridden Methods (Abstract)
    // Deposit if amount is greater than 0
    @Override
    public void deposit(double amount) {
        if(amount > 0){
            balance += amount;
            System.out.printf("Amount of %s applied to account%n", amount);
            //adds transaction to queue
            addTransaction(String.format("Deposit : %s", amount));
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
            System.out.printf("Amount of %s has been withdrawn%n", amount);
            //adds transaction to queue
            addTransaction(String.format("Withdrawn : %s", amount));
        }
        else{
            System.out.println("Amount cannot be withdrawn from account");
        }
    }

    // Prints string values within balance history queue
    @Override
    public void transactionHistory(){
        for(String s : balanceHistory){
            System.out.println(s);
        }
    }

    // Method to add string transaction to balanceHistory
    // ensuring that size does not exceed limit of 5
    private void addTransaction(String transaction) {
        if(balanceHistory.size() == 5) {
            // removes element from queue if size = 5
            balanceHistory.poll();
        }
        // adds transaction string to queue
        balanceHistory.add(transaction);
    }
}
