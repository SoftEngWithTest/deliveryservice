package ie.gmit;

import org.junit.jupiter.api.Test;
import static junit.framework.Assert.assertEquals;

public class DriverValidationTest {

    Driver driver;

    @Test
    public void testDriverValidation(){
        driver = new Driver("113345","999888","John Smyth");
        DriverValidation driverValidation = new DriverValidation();
        assertEquals(false,driverValidation.driverCheck(driver));

    }
}
