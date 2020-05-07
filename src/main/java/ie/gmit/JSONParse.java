package ie.gmit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONParse {

    public static void readJSON() {
        JSONParser jsonParser = new JSONParser();

        try {
            Object obj = jsonParser.parse(new FileReader("customers.json"));
            JSONArray customerList = (JSONArray) obj;

            for(Object customer : customerList) {
                JSONObject customerObject = (JSONObject) customer;
                parseCustomerObject(customerObject);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseCustomerObject(JSONObject customerObject) {
        String firstName = (String) customerObject.get("firstName");
        String lastName = (String) customerObject.get("lastName");
        String email = (String) customerObject.get("email");
        String address = (String) customerObject.get("address");
        String county = (String) customerObject.get("county");
        String eircode = (String) customerObject.get("eircode");

        Customer customer = new Customer(firstName, lastName, email, address, county, eircode);
        Label label = new Label(customer);
    }
}
