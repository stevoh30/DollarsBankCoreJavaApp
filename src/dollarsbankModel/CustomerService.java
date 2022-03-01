package dollarsbankModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import java.io.FileWriter;


public class CustomerService {

    //practice Class
    //private fields
    //Customer customers[] = new Customer[]{};
    public List<Customer> customers = new ArrayList<>();

    //functionality
    //write customer information to json file

    public void Test() throws IOException {

//        Map<String, String> colours = new HashMap<>();
//        colours.put("BLACK", "#000000");
//        colours.put("RED", "#FF0000");
//        colours.put("GREEN", "#008000");
//        colours.put("BLUE", "#0000FF");
//        colours.put("YELLOW", "#FFFF00");
//        colours.put("WHITE", "#FFFFFF");
//
//        // Convert a Map into JSON string.
//        Gson gson = new Gson();
//        String json = gson.toJson(colours);
//        System.out.println("json = " + json);
//
//        // Convert JSON string back to Map.
//        Type type = new TypeToken<Map<String, String>>() {
//        }.getType();
//        Map<String, String> map = gson.fromJson(json, type);
//        for (String key : map.keySet()) {
//            System.out.println("map.get = " + map.get(key));
//        }

        // Converts ArrayList into Json Object
        Customer c = new Customer("Stephen",
                 "Renton",
                 "505-0050",
                 "Stevoh",
                 "Password",
                 500, new PriorityQueue<String>());
        customers.add(c);
        customers.add(c);

        var gson = new Gson();
        String jsonCustomers = gson.toJson(customers);
        System.out.println("jsonCustomers = " + jsonCustomers);

        //save Json Objects to file
        FileWriter writer = new FileWriter("data.json");
        gson.toJson(customers, writer);
        writer.flush();
        writer.close();

        // Converts JSON string into a collection of Customer object.
        Type type = new TypeToken<List<Customer>>() {
        }.getType();
        List<Customer> customerList = gson.fromJson(jsonCustomers, type);

        for (Customer customer : customerList) {
            customer.ToString();
        }
    }
}
