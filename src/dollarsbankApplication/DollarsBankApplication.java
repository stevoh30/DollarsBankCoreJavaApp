package dollarsbankApplication;

import dollarsbankModel.Customer;
import java.util.Scanner;

public class DollarsBankApplication {

    // Testing
    public static void main(String[] args) {
        int[] login_menu_number = new int[]{1, 2, 3};
        String[] login_menu = new String[]{"Create New Account", "Login", "Exit"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to DollarsBank! ");

        for (int i = 0; i < login_menu_number.length; i++) {
            System.out.println(login_menu_number[i] + ". " + login_menu[i] + ";");
        }

        System.out.println("Choose a number(1,2 or 3):");
        int choose_number = scanner.nextInt();
        System.out.println("The number chosen was: "+ choose_number);

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


