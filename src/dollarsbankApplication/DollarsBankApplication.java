package dollarsbankApplication;
import dollarsBankConsoleView.LoginMenu;
import dollarsbankModel.Customer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DollarsBankApplication {

    public static void main(String[] args) {
//        Test();
        LoginMenu lm = new LoginMenu();

        while (lm.welcome_page() != 3) {
            lm.welcome_page();
        }
    }

    //Testing
    public static void Test() {
        Customer c = new Customer("Stephen",
                "Renton",
                "505-0050",
                "Stevoh",
                "Password",
                500, new PriorityQueue<>());

//        c.deposit(250);
//        c.withdraw(10000);
//        c.withdraw(250);
//        c.balanceHistory();
//        c.ToString();
    }
}

