package dollarsbankModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CustomerServices {

    // Class fields
    private ArrayList customers = new ArrayList();

    // Getter methods for accessing array
    public ArrayList getCustomers() {
        this.customers = ReadCustomer();
        return this.customers;
    }

    // Loads json data into arraylist
    private ArrayList<Object> ReadCustomer(){
        JSONParser parser = new JSONParser();
        try(FileReader filereader = new FileReader("user.json")) {
            Object obj =  parser.parse(filereader);
            // extract the json arrays;
            JSONArray array = (JSONArray)obj;

            Iterator iterator = array.iterator();

            while(iterator.hasNext()){
                //read through array and load them into customers arraylist.
                this.customers.add(iterator.next());
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

    // Adds customer object to this.array list
    public ArrayList AddCustomerToArrayList(Customer c){
        //retrieve all the customers existed;
//        this.customers = getCustomers();
        ObjectMapper objectMapper = new ObjectMapper();
        Map customerMap = objectMapper.convertValue(c, Map.class);

        //add one new account info into customers array;
        this.customers.add(customerMap);
        return this.customers;
    }

    //Saves customers arraylist to json file; (checked)
    public void SaveCustomersToJson() throws IOException {
        var gson = new GsonBuilder().setPrettyPrinting().create();
        //save Json Objects to file

        FileWriter writer = new FileWriter("data.json");

        gson.toJson(this.customers, writer);
        writer.flush();
        writer.close();
    }

    // Validate if id has been used upon account creation
    public boolean checkId(String id){
        //check if id exists;
        for(int i =0; i< customers.size(); i++) {
            Map o = (HashMap) customers.get(i);
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
        for(int i=0; i< customers.size(); i++){
            Map o = (HashMap) customers.get(i);
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
