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
            if (customerDB.existsAlready(customer) == false) {
                customerDB.updateDB(customer);
            }

        }

        ParcelDispatch parcelDispatch = new ParcelDispatch();
        parcelDispatch.registerParcelReadyToDispatch();

        while (true)  {

            System.out.println("Select option: \n1: Scan barcode\n2: Type in order ID\n3: Confirm delivery\n");
            Scanner s = new Scanner(System.in);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    // Scanning barcode
                    Driver driver = new Driver(Label.labelList.get(Label.labelList.size()-1), "909088", "John Ward");
                    parcelDispatch.searchOrder(driver.getOrderId());
                    parcelDispatch.registerParcelDispatched(driver);
                    System.out.println("Driver name: " + driver.getDriverName() + "\nDriver ID: " + driver.getDriverId() + "\nOrder ID: " +
                            driver.getOrderId() + "\n***Label***\n" + Label.myList.get(Label.myList.size() - 1));
                    Label.myList.remove(Label.myList.size() - 1);
                    //System.out.println(parcelDispatch.dispatchedList.get());
                    System.out.println("Parcels in the van: "+ parcelDispatch.dispatchedList.toString());
                    break;
                case 2:

                        // Typing in manually order id
                        Scanner sc = new Scanner(System.in);
                        Driver dr = new Driver(sc.nextLine(), "888888", "John");
                        parcelDispatch.searchOrder(dr.getOrderId());
                        parcelDispatch.registerParcelDispatched(dr);
                        System.out.println("Driver name: " + dr.getDriverName() + "\nDriver ID: " + dr.getDriverId() + "\nOrder ID: " +
                                dr.getOrderId() + "\nLabel: " + Label.myList.get(Label.myList.size() - 1));

                        break;

                case 3:
                    //Confirm delivery
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("ENTER order ID : ");
                    parcelDispatch.searchDispatched(scanner.nextLine());

                default:
                    // code block
            }

            //switch case

            //Line below for demo purpose


        }
    }
}
