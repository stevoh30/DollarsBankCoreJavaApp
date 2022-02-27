package dollarsBankConsoleView;
import java.awt.*;
import java.util.Scanner;
import dollarsbankController.DollarsBankController;

public class LoginPage {

    //show login page
    public void login_page(){

        Scanner scanner = new Scanner(System.in);
        DollarsBankController dbc = new DollarsBankController();

        // get the user id;
        System.out.println("========================");
        System.out.print("Enter your user id: ");
        String id = scanner.nextLine();

        // get the user password;
        System.out.println("========================");
        System.out.print("Enter your user password: ");
        String password = scanner.nextLine();

        // use controller to check if they're valid;
        boolean result;
//        = dbc.login_check(id, password);

        // if valid:

    }
}
