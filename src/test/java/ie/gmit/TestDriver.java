package ie.gmit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDriver {
    Driver driver;

    @BeforeAll
    static void startingTests() {
        System.out.println("Starting Tests");
    }

    @BeforeEach
    void printDisplayNames(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry(testInfo.getDisplayName());
    }

    @AfterAll
    static void testingComplete() {
        System.out.println("Testing Complete");
    }

    @DisplayName("Driver constructor test")
    @Test
    void testDriver(){
        driver = new Driver("112345","999888","John Smyth");
        assertEquals("112345",driver.getOrderId());
        assertEquals("John Smyth",driver.getDriverName());
        assertEquals("999888",driver.getDriverId());
    }

    @DisplayName("Driver name test")
    @Test
    void driverNameFail(){
        assertThrows(IllegalArgumentException.class,()->new Driver("123456","999888","34"));
    }

    @DisplayName("Driver ID test")
    @Test
    void driverIdFail(){
       assertThrows(IllegalArgumentException.class,()->new Driver("123456","12","Sarah"));
    }

    @DisplayName("Driver order ID test")
    @Test
    void orderIdFail(){
        assertThrows(IllegalArgumentException.class,()->new Driver("123","999888","John Smyth"));
    }

}
