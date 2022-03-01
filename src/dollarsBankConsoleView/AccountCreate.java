package dollarsBankConsoleView;

import dollarsbankController.DollarsBankController;
import dollarsbankModel.Customer;
import dollarsbankModel.CustomerServices;
import dollarsbankModel.DataSearch;
import dollarsbankModel.SavingsAccount;

import java.util.*;

public class AccountCreate {

    // Class fields
    CustomerServices cs = new CustomerServices();

    // Why is this a map?
    public Map createAccount() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> new_customer = new HashMap<>(6);
        // form the keys;
        String[] keys = {"name", "address", "contactNumber", "id", "password", "initial_balance"};

        //initialize an empty hashmap:
        for (String key : keys) {
            new_customer.put(key, "");
        }
        //traverse through the hashmap;
        outer:
        for (Map.Entry mapElement : new_customer.entrySet()) {
            inner:
            switch ((String) mapElement.getKey()) {
                case "password" -> {
                    System.out.print("Enter Your Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Confirm Your Password: ");
                    String confirmed = scanner.nextLine();
                    if (checkPassword(password, confirmed)) {
                        System.out.println("Passwords match! ");
                        // put the password into the new_customer hash map;
                        new_customer.put((String) mapElement.getKey(), password);

                    } else {
                        startOver();
                    }
                }
                case "initial_balance" ->{
                    try {
                        System.out.print("Enter Your Initial Balance(e.g. 1023.23): ");
                        Double initial = scanner.nextDouble();
                        new_customer.put((String) mapElement.getKey(), initial);
                    } catch (InputMismatchException e){
                        System.out.println("Make Sure You Enter a Number;");
                    }
                }
                case "id" ->{
                    System.out.print("Enter Your Preferred ID for Login(e.g. 'Stevoh' for 'Steven'): ");
                    String id = scanner.nextLine();
                    //use checkId method in DataSearch class;
                    if(cs.checkId(id)){
                        new_customer.put((String)mapElement.getKey(), id);
                    }else{
                        startOver();
                    }
                }
                default -> {
                    System.out.printf("Enter Your %s: %n", mapElement.getKey());
                    String x = scanner.nextLine();
                    new_customer.put((String)mapElement.getKey(), x);
                }
            }
        }
        return new_customer;
    }

    public boolean checkPassword(String pwd, String confirmedPwd){

        if(pwd.equals(confirmedPwd) && pwd.length() > 3){
            return true;
        }else{
            System.out.println("Passwords Do Not Match or Less Than 4 Characters! ");
        }
        return false;
    }

    public void startOver(){
        System.out.println("Now let's start over! ");
        System.out.println("==============================================================");
        createAccount();
    }

    public void deserializeCustomer(){
        Map map = createAccount();
        Customer customer = new Customer((String)map.get("name"),
                (String)map.get("address"),
                (String)map.get("contactNumber"),
                (String)map.get("id"),
                (String)map.get("password"),
                (Double)map.get("initial_balance"),
                new PriorityQueue<>()
        );

        customer.ToString();
        System.out.println("Created New Account Successfully! Thank You for Choosing DollarsBank! ");
    }
}
