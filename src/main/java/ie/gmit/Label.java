/* This class generates a label as a JSON Object which
   includes the customer's details (which is received as a Customer object)
   plus a randomly generated unique order ID

   ---
 */

package ie.gmit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Label {
    private static long uniqueID;
    public static String orderId;
    static private ArrayList<Long> orderIDList = new ArrayList<>();

    public Label(Customer customer) throws JsonProcessingException {
        uniqueID = generateUniqueID();
        generateLabel(customer);
    }

    public long generateUniqueID() {
        // Generating random number between 10000 and 20000
        long min = 100000;
        long max = 200000;
        boolean alreadyExists = false;

        long ID = (long)(Math.random() * (max - min + 1) + min);

        for (long id : orderIDList) {
            if(id == ID) {
                alreadyExists = true;
                throw new IllegalArgumentException("ID Already Exists");
            }
            else {
                alreadyExists = false;
            }
        }

        if(alreadyExists == false) {
            orderIDList.add(ID);
        } else {
            // ALREADY EXISTS
            throw new IllegalArgumentException("ID already exists - regenerating ID");
        }

        return ID;
    }

    public static List <String> labelList = new ArrayList<>();
    public static List <String> myList = new ArrayList<>();

    /**
     *Creation of JSON object and deserialization
     */
    public static String generateLabel(Customer customer) throws JsonProcessingException {
        // Create JSON object
        JSONObject label = new JSONObject();
        label.put("firstName", customer.getFirstName());
        label.put("lastName", customer.getLastName());
        label.put("email", customer.getEmail());
        label.put("address", customer.getAddress());
        label.put("eircode", customer.getEircode());
        label.put("orderID", uniqueID);

        String list = label.toString();
        //Deserialising JSON into String object
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(label);
        System.out.println(jsonString);
        LabelModel labelModel = objectMapper.readValue(jsonString,LabelModel.class);

        String finalLabel = labelModel.getFirstName()+" "+labelModel.getLastName()+"\n"+labelModel.getAddress()+
                "\n"+labelModel.getEircode()+"\n"+labelModel.getOrderID();
        orderId =  label.get("orderID").toString();
        labelList.add(orderId);
        myList.add(finalLabel);

        System.out.println("Customer Label: "+ finalLabel);
        return list;
    }


    public long getUniqueID() { return uniqueID; }

    public void setUniqueID(long uniqueID) { this.uniqueID = uniqueID; }

    public static ArrayList<Long> getOrderIDList() { return orderIDList; }

    public void setOrderIDList(ArrayList<Long> orderIDList) {
        this.orderIDList = orderIDList;
    }

}