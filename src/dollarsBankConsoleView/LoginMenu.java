package dollarsBankConsoleView;


import java.util.Arrays;
import java.util.Scanner;
import dollarsbankController.DollarsBankController;

public class LoginMenu {

    // class fields
    private int selectionNumber = 0;

    // get method for accessing selection Number
    public int getSelectionNumber() {
        return selectionNumber;
    }

    // functionality for allowing the user to select various choices
    // in welcome_page menu
    public int welcome_page(){
        //initialize menu
        int[] login_menu_number = new int[]{1,2, 3};
        String[] login_menu = new String[]{"Create New Account", "Login", "Exit"};

        // set scanner to get user input;
        Scanner scanner = new Scanner(System.in);

        //print out the menu choices;
        System.out.println("Welcome to DollarsBank! ");
        for (int i = 0; i < login_menu_number.length; i++) {
            System.out.println(login_menu_number[i] + ". " + login_menu[i] + ";");
        }
        System.out.print("Choose a number(1,2 or 3):" );

        //get user's choice;
        int chosen_number = scanner.nextInt();

        //check if user's input is in the menu;
//        int result = Arrays.binarySearch(login_menu_number, chosen_number);
//        boolean check_number = result > -1 ;
        this.selectionNumber =  chosen_number;
        return chosen_number;
    }
}
