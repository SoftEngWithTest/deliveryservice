package ie.gmit;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import static junit.framework.Assert.assertEquals;

public class DriverValidationTest {

    Driver driver;
    Label label;
    Customer customer;
    DriverValidation dv;

    @Test
    public void testDriverValidation(){
        driver = new Driver("113345","999888","John Smyth");
        dv = new DriverValidation();
        assertEquals(false,dv.driverCheck(driver));

    }
    @Test
    public void testDriverIsValid() throws JsonProcessingException {
        driver = new Driver("444444","999888","John Smyth");
       customer = new Customer("John","Walsh","sample@mail.com"," 2 test street","Dublin","K32 I765");
        label = new Label(customer);
        dv = new DriverValidation();
        Label.labelList.add("444444");

        assertEquals(true,dv.isValidId(driver));

    }
}
