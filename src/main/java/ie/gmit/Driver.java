package ie.gmit;

/**
 * Driver provides driver id ,order id and name
 * Driver manually inputs order id(unique) and need to validate with ID's that are stored in ready to dispatch List
 */
public class Driver {
    private String orderId;
    private String driverId;
    private String driverName;

    public Driver(){

    }
    public Driver(String driverId,String driverName){
        setDriverId(driverId);
        setDriverName(driverName);

    }

    public Driver (String orderId,String driverId,String driverName) {
        setOrderId(orderId);
        setDriverId(driverId);
        setDriverName(driverName);
    }



    /**
     *Getters and setters
     */
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        Driver driver = new Driver();
        DriverValidation driverValidation = new DriverValidation();
        boolean validId = driverValidation.driverCheck(driver);


        if (!orderId.matches("[0-9]+") || orderId.length()!=6) {
            throw new IllegalArgumentException("Invalid order ID number");
        }
        else if(validId){
            throw  new IllegalArgumentException("Order id does not match");
        }
        else

        this.orderId = orderId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String d) {
        if ( d.length()!=6) {
            throw new IllegalArgumentException("Invalid driver ID number length, must be 6 digits long");
        }
        else{
            this.driverId = d;
            }

    }
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        if (driverName.matches("[a-z A-Z_]+")) {
            this.driverName = driverName;
        }
        else {
            throw new IllegalArgumentException("Invalid driver name , can contain only letters");
        }
    }
}
