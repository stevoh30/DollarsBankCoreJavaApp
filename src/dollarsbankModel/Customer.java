package dollarsbankModel;

import java.util.Queue;

public class Customer {

    // Customer Properties
    private final String name;
    private final String address;
    private final String contactNumber;
    private final String id;
    private final String password;

    private final SavingsAccount customerSavings;

    // Constructor
    public Customer(String name, String address, String contactNumber,
                    String id, String password, double amount, Queue<String> queue){
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.id = id;
        this.password = password;
        customerSavings = new SavingsAccount(amount, queue);
    }

    // Method to print customer information and balance
    public void ToString(){
        System.out.printf("Name: %s\nAddress: " +
                        "%s\nContact: %s\nID: %s\nPassword: %s\nBalance: $%s\n%n",
                name, address, contactNumber, id, password, customerSavings.getBalance());
    }

    // accepts an amount and a customer object to transfer funds
    // between this account and additional customer
    public void transfer(double amount, Customer customer){
        if(amount < this.customerSavings.balance){
            this.withdraw(amount);
            customer.deposit(amount);
        }
    }

    // allows methods to be accessible through customer class
    public void deposit(double amount){
        customerSavings.deposit(amount);
    }

    public void withdraw(double amount){
        customerSavings.withdraw(amount);
    }

    public void balanceHistory(){ customerSavings.transactionHistory();}


}
