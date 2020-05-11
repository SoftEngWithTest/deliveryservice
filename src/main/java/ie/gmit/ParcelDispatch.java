package ie.gmit;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class responsible for dispatching operations
 */
public class ParcelDispatch {

   private List<String> deliveredList = new ArrayList<>();
   public ArrayList<Driver> dispatchedList = new ArrayList<>();
   public ArrayList<String>readyToDispatchList = new ArrayList();
   public static boolean orderMatch=false;
    /**
     * Method registers package as "Dispatched" by van driver
     */
    public void registerParcelDispatched(Driver driver){

            dispatchedList.add(driver);
            System.out.println("Parcel dispatched");
            readyToDispatchList.remove(searchOrder(driver.getOrderId()));
            System.out.println("Order removed from LIST: " + driver.getOrderId());

    }

    /**
     * Method registers package as "Ready to dispatch"
     */
    public void registerParcelReadyToDispatch(){

        for(int i =0;i<Label.labelList.size();i++) {
            readyToDispatchList.add(Label.labelList.get(i));
        }
        System.out.println("Parcels ready for dispatch: "+readyToDispatchList);
    }

    /**
     * This method is searching order in a list of "ready to dispatch"
     */
    public String searchOrder(String order){
       // Driver driver = new Driver();//("576734","000000","Sam");
        String result = order ;//
        for(String ord : readyToDispatchList)
        {
            if(ord.equals(order)){

                System.out.println("PARCEL MATCH");
                result = order;
                orderMatch = true;
            }
            else{
                System.out.println("NO MATCHING ORDER ID");
                result = null;
                orderMatch = false;
            }
        }
        return result;
    }

    public String searchDispatched(String orderRef){
        String result = orderRef; //This is orderID provided to customer at POS
        for(int i=0;i<dispatchedList.size();i++){
            String order= dispatchedList.get(i).getOrderId();
                if (orderRef.equals(order)) {
                    System.out.println("Parcel match");
                    result = orderRef;
                    confirmDelivery(i);

                } else {
                    System.out.println("No matching parcel");
                    result = null;
                }
            }
        return result;
    }

    public void confirmDelivery(int i){
            deliveredList.add(dispatchedList.get(i).toString());
            System.out.println("Parcel ID number " + dispatchedList.get(i).getOrderId()+" registered as DELIVERED");
            dispatchedList.remove(i);
        }

}
