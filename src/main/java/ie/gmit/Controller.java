package ie.gmit;

import java.util.ArrayList;

public class Controller {
    public static void main(String[] args) {
        ArrayList<Customer> customers;

        JSONParse parser = new JSONParse();
        customers = parser.readJSON("customers.json");
        for (Customer customer : customers) {
            Label label = new Label(customer);
        }
    }
}
