package ie.gmit;

/**
 * This class is used by driver. Driver must provide correct format of order ID
 */
public class Order {
    private String orderId;

    public Order(String orderId){
        setOrderId(orderId);
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {

        if(orderId.length()!=6){
            throw new IllegalArgumentException("Order ID must be 6 digits long ");
        }
        this.orderId = orderId;
    }
}
