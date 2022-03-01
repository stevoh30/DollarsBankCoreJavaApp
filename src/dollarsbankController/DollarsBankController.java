package dollarsbankController;

import dollarsBankConsoleView.AccountCreate;
import dollarsBankConsoleView.LoginMenu;
import dollarsBankConsoleView.LoginPage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class DollarsBankController {

    //start the app with LoginMenu page and load data into cusomters.
    public void starter(){
        fetchLoginMenu();
        ArrayList customers = ReadCustomer();
    }

    public ArrayList<Object> ReadCustomer(){
        JSONParser parser = new JSONParser();
        ArrayList<Object> customers = new ArrayList<>();
        try(FileReader filereader = new FileReader("user.json")) {
            Object obj =  parser.parse(filereader);
            // extract the json arrays;
            JSONArray array = (JSONArray)obj;

            Iterator iterator = array.iterator();

            while(iterator.hasNext()){
                //read through array and load them into customers arraylist.
                customers.add(iterator.next());
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    public Map getCustomer(String id){
        Map<String, Object> customer = new HashMap<>();
        return customer;
    }

    public void fetchLoginMenu(){
        LoginMenu lm = new LoginMenu();
        while (lm.welcome_page() != 3) {
            lm.welcome_page();
        }
    }

    public void fetchAccountCreate(){
        AccountCreate ac = new AccountCreate();
        ac.deserializeCustomer();
    }

    public void fetchLoginPage(){
        LoginPage lp = new LoginPage();
        lp.login_page();
    }


}


