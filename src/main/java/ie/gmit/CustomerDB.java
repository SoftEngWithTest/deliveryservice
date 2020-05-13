/* This class simulates our Customer database */

package ie.gmit;

import java.util.ArrayList;

public class CustomerDB {
    private ArrayList<Long> customerDB = new ArrayList<>();

    public CustomerDB() {
        // When new instance of CustomerDB is made,
        // Add all customers that already exist in our DB to an array list
        customerDB.add((long) 334456);
        customerDB.add((long) 784567);
        //customerDB.add(967654);
    }

    public boolean existsAlready(Customer customer) {
        boolean result = false;

        // Loop through DB checking for customer's ID
        for(Long ID : customerDB) {
            if(customer.getCustomerID() == ID) {
                result = true;
                return result;
            }
        }

        return result;
    }

    public void updateDB(Customer customer) {
        customerDB.add(customer.getCustomerID());
        System.out.println("ID: " + customer.getCustomerID() + " was added to the database");
        System.out.println(customerDB);
    }

    public ArrayList<Long> getCustomerDB() {
        return customerDB;
    }
}