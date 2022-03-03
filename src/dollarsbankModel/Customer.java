package dollarsbankModel;

import java.io.PrintStream;
import java.util.PriorityQueue;
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
                    String id, String password, double balance, Queue<String> queue){
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.id = id;
        this.password = password;
        customerSavings = new SavingsAccount(balance, queue);
    }


    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }


    public SavingsAccount getCustomerSavings() {
        return customerSavings;
    }

    // Method to print customer information and balance
    public void ToString(){
        System.out.println("=============================================");
        PrintStream printf = System.out.printf("""
                        Name: %s;  
                        Address: %s;  Contact: %s;
                        ID: %s, Password: %s;    
                        """,
                name,
                address,
                contactNumber,
                id,
                password);
        getCustomerSavings().transactionHistory();
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
