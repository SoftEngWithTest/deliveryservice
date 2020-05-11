package ie.gmit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDriver {
    Driver driver;

    @Test
    void testDriver(){
        driver = new Driver("112345","999888","John Smyth");
        assertEquals("112345",driver.getOrderId());
        assertEquals("John Smyth",driver.getDriverName());
        assertEquals("999888",driver.getDriverId());
    }
    @Test
    void driverNameFail(){

        assertThrows(IllegalArgumentException.class,()->new Driver("123456","999888","34"));
    }
    @Test
    void driverIdFail(){

        assertThrows(IllegalArgumentException.class,()->new Driver("123456","12","Sarah"));
    }
    @Test
    void orderIdEntryFail(){

        assertThrows(IllegalArgumentException.class,()->new Driver("123","999888","John Smyth"));
    }
    @Test
    void testOrderIdNotMatch(){
        assertThrows(IllegalArgumentException.class,()->new Driver ("555555","123123","Colin Brown"));
    }

}
