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
