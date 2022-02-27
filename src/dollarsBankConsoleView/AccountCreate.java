package dollarsBankConsoleView;

import dollarsbankModel.Customer;
import java.util.*;


public class AccountCreate {

    public Map createAccount() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> new_customer = new HashMap<>(6);
        // form the keys;
        String[] keys = {"name", "address", "contactNumber", "id", "password", "initial_balance"};

        //initial an empty hashmap:
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
                            new_customer.put((String) mapElement.getKey(), password);

                        } else {
                            System.out.println("Now let's start over! ");
                            System.out.println("==============================================================");
                            startOver();
                        }
                    }
                case "initial_balance" ->{
                    System.out.print("Enter Your Initial Balance(e.g. 1023.23): ");
                    Double initial = scanner.nextDouble();
                    new_customer.put((String) mapElement.getKey(),initial);

                }
                case "id" ->{
                    System.out.print("Enter Your Preferred ID in three digits(e.g. 101): ");
                    String id = scanner.nextLine();
                    if(checkId(id)){
                        new_customer.put((String)mapElement.getKey(), id);
                    }else{
                        System.out.println("ID has been taken! Try another one! Now let's start over! ");
                        System.out.println("==============================================================");
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
            System.out.println("Passwords Do Not Match or Less Than 5 Characters! ");
        }
        return false;
    }
    public boolean checkId(String id){

        //code to be implemented here:
        return true;
    }

    public void startOver(){
        createAccount();
    }

    public void DeserializeCustomer(){
        Map map = createAccount();

        Customer customer = new Customer(map.get("name").toString(),
                map.get("address").toString(),
                map.get("contactNumber").toString(),
                map.get("id").toString(),
                map.get("password").toString(),
                (Double)map.get("initial_balance"));
        System.out.println(customer);
        System.out.println("Created New Account Successfully! Thank You for Choosing DollarsBank! ");
    }
}
