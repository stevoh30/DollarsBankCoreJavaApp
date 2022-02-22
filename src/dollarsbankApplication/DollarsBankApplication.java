package dollarsbankApplication;
import dollarsBankConsoleView.LoginMenu;

public class DollarsBankApplication {

    // Testing
    public static void main(String[] args) {
        LoginMenu lm = new LoginMenu();

        while(lm.login_page() != 3){
            lm.login_page();
        }
    }
}
//        Customer c = new Customer("Stephen",
//                "Renton",
//                "505-0050",
//                "Stevoh",
//                "Password",
//                500);
//
//        c.customerSavings.deposit(250);
//        c.customerSavings.withdraw(10000);
//        c.ToString();
//    }


