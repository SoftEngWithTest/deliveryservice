package ie.gmit;

/**
 * Driver provides driver id ,package id and name
 */
public class Driver {
    private String orderId;
    private String driverId;
    private String driverName;


    public Driver (String packageId,String driverId,String driverName){
        this.orderId = packageId;
        this.driverId = driverId;
        this.driverName = driverName;
    }
    /**
     *Getters and setters
     */
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if (!orderId.matches("[0-9]+")) {
            System.out.println("Invalid number");
        }
        this.orderId = orderId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        if (!driverId.matches("[0-9]+")) {
            System.out.println("Invalid number");
        }
        this.driverId = driverId;
    }
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }



}
