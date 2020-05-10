package ie.gmit;

import java.util.ArrayList;

public class Controller {

    public static void main(String[] args) {
        ArrayList<Customer> customers;
        CustomerDB customerDB = new CustomerDB();

        JSONParse parser = new JSONParse();
        customers = parser.readJSON("customers.json");
        for (Customer customer : customers) {
            Label label = new Label(customer);

            // send customer to DB to check if customer exists
            // update details if needed

            // If customer doesn't exist, then add them in
            if(customerDB.existsAlready(customer) == false) {
                customerDB.updateDB(customer);
            }

        }
    }
}
