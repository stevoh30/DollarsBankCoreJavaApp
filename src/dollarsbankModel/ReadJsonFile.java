package dollarsbankModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFile {

    // Practice Code
    public static void main(String[] arg){
        JSONParser parser = new JSONParser();


        try(FileReader filereader = new FileReader("CustomerAccount.json")) {
            Object obj =  parser.parse(filereader);
            JSONArray array = (JSONArray)obj;

            JSONObject jsonObject = (JSONObject)array.get(1);

            System.out.println(jsonObject.get("address"));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
