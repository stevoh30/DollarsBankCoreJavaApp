package dollarsbankApplication;
import dollarsBankConsoleView.LoginMenu;
import dollarsbankModel.Customer;

import java.util.PriorityQueue;
import java.util.Queue;

public class DollarsBankApplication {

    public static void main(String[] args) {
        Test();
        LoginMenu lm = new LoginMenu();

        while (lm.welcome_page() != 3) {
            lm.welcome_page();
        }
    }
// <<<<<<< HEAD
//     // Testing
//     public static void Test(){
// =======

//     //Testing
//     public static void Test() {
// >>>>>>> 2c2b1eb1ecda8acde95f5bad807bdcd4b52038b2
//         Customer c = new Customer("Stephen",
//                 "Renton",
//                 "505-0050",
//                 "Stevoh",
//                 "Password",
// <<<<<<< HEAD
//                 500, new PriorityQueue<String>());

//         c.deposit(250);
//         c.withdraw(10000);
//         c.withdraw(250);
//         c.balanceHistory();
//         c.ToString();
//     }

// =======
//                 500, new PriorityQueue<>());

// //        c.deposit(250);
// //        c.withdraw(10000);
// //        c.withdraw(250);
// //        c.balanceHistory();
// //        c.ToString();
//     }
// >>>>>>> 2c2b1eb1ecda8acde95f5bad807bdcd4b52038b2
}

