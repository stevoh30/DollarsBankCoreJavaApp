package dollarsbankModel;

public class Customer {

    // Customer Properties
    public String name;
    public String address;
    public String contactNumber;
    public String id;
    public String password;
    public SavingsAccount customerSavings;

    // Constructor
    public Customer(String name, String address, String contactNumber, String id, String password, double amount){
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.id = id;
        this.password = password;
        customerSavings = new SavingsAccount(amount);
    }

    public void ToString(){
        System.out.println(String.format("Name: %s\nAddress: " +
                "%s\nContact: %s\nID: %s\nPassword: %s\nBalance: $%s\n",
                name, address, contactNumber, id, password, customerSavings.balance));
    }
}
