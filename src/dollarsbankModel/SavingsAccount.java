package dollarsbankModel;

import java.util.Queue;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class SavingsAccount extends Account{

    // Constructor
    public SavingsAccount(double balance, Queue<String> balanceHistory){
        super(balance, balanceHistory);
    }
    //get local time;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String time = dtf.format(now);
    // Overridden Methods (Abstract)
    // Deposit if amount is greater than 0
    @Override
    public void deposit(double amount) {
        if(amount > 0){
            balance += amount;
            System.out.printf("%s Amount of %s applied to account; Balance: %.2f %n", time, amount,balance);

            //adds transaction to queue
            addTransaction(String.format("%s Deposit: %s; Balance: %.2f %n", time, amount, balance)); // added balance into the transaction history.
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
            System.out.printf("%s Amount of %s has been withdrawn; Balance: %.2f %n", time, amount, balance);
            //adds transaction to queue
            addTransaction(String.format("%s Withdrawn: %s; Balance: %.2f %n", time, amount, balance));
        }
        else{
            System.out.println("Amount cannot be withdrawn from account");
        }
    }

    // Prints string values within balance history queue
    @Override
    public void transactionHistory(){
        for(String s : balanceHistory){
            System.out.print("Transaction made -- "+ s );
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
