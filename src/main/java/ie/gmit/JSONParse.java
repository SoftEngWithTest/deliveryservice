package ie.gmit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSONParse {

    public static ArrayList<Customer> readJSON(String fileName) {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Customer> customers = new ArrayList<>();

        try {
            Object obj = jsonParser.parse(new FileReader(fileName));
            JSONArray customerList = (JSONArray) obj;

            for(Object customer : customerList) {
                JSONObject customerObject = (JSONObject) customer;
                Customer c = parseCustomerObject(customerObject);
                customers.add(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return array list of Customers
        return customers;
    }

    public static Customer parseCustomerObject(JSONObject customerObject) {
        long customerID = (long) customerObject.get("customerID");
        String firstName = (String) customerObject.get("firstName");
        String lastName = (String) customerObject.get("lastName");
        String email = (String) customerObject.get("email");
        String address = (String) customerObject.get("address");
        String county = (String) customerObject.get("county");
        String eircode = (String) customerObject.get("eircode");

        Customer customer = new Customer(customerID, firstName, lastName, email, address, county, eircode);

        return customer;
    }
}
