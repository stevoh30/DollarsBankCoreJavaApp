package dollarsbankApplication;

import dollarsbankModel.Customer;

public class DollarsBankApplication {

    // Testing
    public static void main(String[] args){
        Customer c = new Customer("Stephen",
                "Renton",
                "50505050",
                "Stevoh",
                "Password",
                500);
        c.ToString();
    }
}
