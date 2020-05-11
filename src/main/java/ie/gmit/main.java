package ie.gmit;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        JSONParse parser = new JSONParse();

        parser.readJSON();

        //switch case
        Driver driver = new Driver(Label.orderId,"888888","John");
        ParcelDispatch parcelDispatch = new ParcelDispatch();
        parcelDispatch.registerParcelReadyToDispatch();
        //Can add scanner in here
        System.out.println("***Scan barcode or type in order ID***");
        //Case 1
        parcelDispatch.searchOrder("111222");
        //Case 2
        System.out.println("Scanning barcode");
        parcelDispatch.searchOrder(driver.getOrderId());
        parcelDispatch.registerParcelDispatched(driver);

        // <Label.myList.get> replicates driver picking one parcel to put inside van
        System.out.println("Driver name: "+driver.getDriverName()+"\nDriver ID: "+driver.getDriverId()+"\nOrder ID: "+
                driver.getOrderId()+"\nLabel: "+Label.myList.get(Label.myList.size()-1));

        //Show order ID
        System.out.println(driver.getOrderId());

        //Customer provides driver with orderID(reference) that must be typed in
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER order ID : ");
        parcelDispatch.searchDispatched(scanner.nextLine());
    }
}
