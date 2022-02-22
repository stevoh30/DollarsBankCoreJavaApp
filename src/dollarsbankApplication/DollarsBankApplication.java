package dollarsbankApplication;

import dollarsbankModel.Customer;

public class DollarsBankApplication {

    // Testing
    public static void main(String[] args){
        Customer c = new Customer("Stephen",
                "Renton",
                "505-0050",
                "Stevoh",
                "Password",
                500);

        c.customerSavings.deposit(250);
        c.customerSavings.withdraw(10000);
        c.ToString();
    }
}
