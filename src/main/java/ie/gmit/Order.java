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
        this.orderId = orderId;
    }
}
