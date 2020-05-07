package ie.gmit;

public class Order {
    private Integer orderId;

    public Order(Integer orderId){
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        String s = orderId.toString();
        if(s.length()!=6){
            throw new IllegalArgumentException("Order ID must be 6 digits long ");
        }
        this.orderId = orderId;
    }
}
