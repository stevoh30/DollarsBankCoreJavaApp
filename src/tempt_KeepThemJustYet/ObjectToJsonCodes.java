package tempt_KeepThemJustYet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dollarsbankModel.Customer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class ObjectToJsonCodes {

    // Practice Code - converts class objects into json data
    public static void main(String[] args) {

        //serialization object -> json;
        //initialize a gson instance;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //use Object Mapper in Jackson to convert a class object into a hashmap;
        ObjectMapper objectMapper = new ObjectMapper();

        //initial an arraylist called customers to store all the customer info.
        List<Object> customers = new ArrayList<>();

        //define a new customer object;
        Customer customer_1 = new Customer(
                "Ying Chen",
                "Maryland",
                "02",
                "yc",
                "abc123",
                3233,
                new PriorityQueue<>(){}
        );
        Customer customer_2 = new Customer(
                "Stevoh",
                "Washington",
                "01",
                "stev",
                "abc456",
                5000,
                new PriorityQueue<>(){}
        );

        Queue<Object> customerQueue = new LinkedList<>();
        // add only customer_1 to the queue.
        customerQueue.add(customer_1);
        customerQueue.add(customer_2);


        try{
            Writer writer = new FileWriter("user.json" );
            while(!customerQueue.isEmpty()){
                //using jackson to turn object into map;
                Map customerMap = objectMapper.convertValue(customerQueue.poll(), Map.class);
                //put all the hashmap into an arraylist
                customers.add(customerMap);
            }
            gson.toJson(customers, writer);
            writer.flush();
            writer.close();

        }catch(IOException e){
            System.err.println("IOException!!!!!!!!!!!!");
            e.printStackTrace();
        }


        // deserialization; json -> object
//        JsonElement fileElement;
//        File input = new File("CustomerAccount.json");
//        try {
//            fileElement = JsonParser.parseReader(new FileReader(input));
////            JsonObject fileObject = fileElement.getAsJsonObject();
//
//            // process all customers:
//            JsonArray customerArray = fileElement.getAsJsonArray();
//            for(JsonElement perCustomer : customerArray){
//                //get json object:
//                JsonObject customer = perCustomer.getAsJsonObject();
//                String c_name = customer.get("name").getAsString();
//                Double initial_balance = customer.get("initial_balance").getAsDouble();
//                System.out.printf("The name of the customer is: %s, and the initial balance is: %.2f %n", c_name, initial_balance);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


        // write a hashmap into a json file;
//        try {
//
//            Map<String, Object> map = new HashMap<>();
//            map.put("name", "John Deo");
//            map.put("email", "john.doe@example.com");
//            map.put("roles", new String[]{"Member", "Admin"});
//
//
//            Writer writer = new FileWriter("user.json");
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            gson.toJson(map, writer);
////            System.out.println(map.get("name"));
//            writer.flush();
//            writer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
