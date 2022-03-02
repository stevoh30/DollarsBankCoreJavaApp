package dollarsBankConsoleView;

import dollarsbankModel.Customer;
import dollarsbankModel.CustomerServices;
import dollarsbankModel.SavingsAccount;

import java.lang.reflect.Array;
import java.util.*;

public class AccountCreate {

    // Class fields
    CustomerServices cs;

    // Constructor
    public AccountCreate(CustomerServices cs){
        this.cs = cs;
    }

    public Customer createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter your preferred id: ");
        String id = scanner.nextLine();
        while(!cs.checkId(id)){

            System.out.print("Try another one: ");
            id = scanner.nextLine();
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm your password: ");
        String confirmed = scanner.nextLine();
        while(!checkPassword(password, confirmed)){

            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            System.out.print("Confirm your password: ");
            confirmed = scanner.nextLine();
        }

        System.out.print("Enter your initial balance: ");
        double ib = scanner.nextDouble();

        Queue<String> q = new LinkedList<>();
        Customer cs = new Customer(name,address,contactNumber,id,password,0,q);
        cs.deposit(ib);
        return cs;
    }


    public boolean checkPassword(String pwd, String confirmedPwd){

        if(pwd.equals(confirmedPwd) && pwd.length() > 3){
            return true;
        }else{
            System.out.println("Passwords Do Not Match or Less Than 4 Characters! ");
        }
        return false;
    }

    public void deserializeCustomer(){
        createAccount().ToString();
        System.out.println("Created New Account Successfully! Thank You for Choosing DollarsBank! ");
        System.out.println();
    }
}
