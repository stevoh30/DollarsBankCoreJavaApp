package dollarsBankConsoleView;
import java.util.Scanner;

import dollarsbankModel.CustomerServices;

public class LoginPage {

    // Class fields
    CustomerServices cs;

    // Login page takes a customer services object when initialized
    public LoginPage(CustomerServices cs){
        this.cs = cs;
    }

    //show login page
    public int login_page() {

        Scanner scanner = new Scanner(System.in);

        // get the user id;
        System.out.println("========================");
        System.out.print("Enter your user id: ");
        String id = scanner.nextLine();

        // get the user password;
        System.out.println("========================");
        System.out.print("Enter your user password: ");
        String password = scanner.nextLine();

        if (cs.checkLogin(id, password)) {
            // should start  the user page (with 6 operations);
            System.out.println("hahah, going into user page...");
        } else {
            System.out.println("Our Bank Does Not Have a User with ID or Password Entered. ");
            System.out.println("========================");
            System.out.println("Enter 1 to start again or any key to exit to the main menu;");
            Integer x = scanner.nextInt();
            if (x.equals(1)) {
                return 1;
            }
        }
        return 2;
    }
}
