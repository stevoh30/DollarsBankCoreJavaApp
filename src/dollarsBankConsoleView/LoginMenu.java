package dollarsBankConsoleView;


import java.util.Arrays;
import java.util.Scanner;

public class LoginMenu {
    public int login_page(){

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
        System.out.println("Choose a number(1,2 or 3):" );

        //get user's choice;
        int chosen_number = scanner.nextInt();
        //check if user's input is in the menu;
        int result = Arrays.binarySearch(login_menu_number, chosen_number);
        boolean check_number = result > -1 ;

        if(check_number){
            if(chosen_number == 3){
                System.out.println("Thank you for choosing DollarsBank, goodbye!");
                System.exit(0);
            }
            System.out.println("The number chosen was: " + chosen_number);

        }else{
            System.out.println("Sorry but the number you chose was not in the menu!");
        }
        return chosen_number;
    }
}
