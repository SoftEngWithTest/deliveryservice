package ie.gmit;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for dispatching operations
 */
public class ParcelDispatch {

   private ArrayList<Driver> dispatchedList = new ArrayList<>();
   private ArrayList<Order>readyToDispatchList = new ArrayList();

    /**
     * Method registers package as "Dispatched" by van driver
     */
    public void registerParcelDispatched(Driver driver){
        dispatchedList.add(driver);
        System.out.println("Parcel dispatched");
    }

    /**
     * Method registers package as "Ready to dispatch"
     */
    public void registerParcelReadyToDispatch(Order order){
        readyToDispatchList.add(order);
        System.out.println("Parcel is ready for dispatch");
    }

    /**
     * This method is locating order in a list
     */
    public Order locateOrder(Order order){

        Order result = new Order(12345);

        for(Order or : readyToDispatchList)
        {
            if(or.equals(order)){
                result = order;
            }
            else{
                result = null;
            }
        }
        return result;
    }

}
