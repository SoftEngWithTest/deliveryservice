package ie.gmit;

/**
 * Class is validating if driver provided correct Order ID
 */
public class DriverValidation {

    public boolean driverCheck(Driver driver){
        return isValidId(driver);
    }

  public static boolean isValidId(Driver driver){
        boolean result = false;
        for(int i=0;i<Label.labelList.size();i++){
            if(Label.labelList.get(i)==driver.getOrderId()){
                result = true;
            }
            else
                result = false;
        }
        return result;
    }
}
