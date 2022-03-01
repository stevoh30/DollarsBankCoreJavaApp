package dollarsbankModel;

import dollarsbankController.DollarsBankController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataSearch {

    // Passes in array of customers
    ArrayList all_customers;

    public DataSearch(ArrayList all_customers) {
        this.all_customers = all_customers;
    }

    // Validate if id has been used upon account creation
    public boolean checkId(String id){
        //check if id exists;
        for(int i =0; i< all_customers.size(); i++) {
            Map o = (HashMap) all_customers.get(i);
            if (o.get("id").equals(id)) {
                System.out.println("++++ Id has been taken, please enter a new one +++ ");
                return false;
            }
        }
        //check id length;
        if(id.length() < 2 || id.isEmpty()){
            System.out.println("Preferred id has to be more than 2 character;");
            return false;
        }
        return true;
    }

    // Checks if username and password are valid before login
    public boolean checkLogin(String id, String pwd){
        for(int i=0; i< all_customers.size(); i++){
            Map o = (HashMap) all_customers.get(i);
            if(o.get("id").equals(id) && o.get("password").equals(pwd)){
                System.out.println("==== Login Successfully! ====");
                return true;
            }
            else {
                continue;
            }
        }
        return false;
    }
}
