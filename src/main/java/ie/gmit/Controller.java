package ie.gmit;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws JsonProcessingException {
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

        //switch case
        Driver driver = new Driver(Label.orderId,"888888","John");
        ParcelDispatch parcelDispatch = new ParcelDispatch();
        parcelDispatch.registerParcelReadyToDispatch();
        parcelDispatch.searchOrder("111222");
        parcelDispatch.searchOrder(driver.getOrderId());
        parcelDispatch.registerParcelDispatched(driver);
        System.out.println("Driver name: "+driver.getDriverName()+"\nDriver ID: "+driver.getDriverId()+"\nOrder ID: "+
                driver.getOrderId()+"\nLabel: "+Label.myList.get(Label.myList.size()-1));

        //Line below for demo purpose
        System.out.println(driver.getOrderId());
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER order ID : ");
        parcelDispatch.searchDispatched(scanner.nextLine());
    }
}
