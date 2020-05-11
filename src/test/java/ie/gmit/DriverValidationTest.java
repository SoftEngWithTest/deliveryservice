package ie.gmit;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.*;

import static junit.framework.Assert.assertEquals;

public class DriverValidationTest {

    Driver driver;
    Label label;
    Customer customer;
    DriverValidation dv;

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

    @DisplayName("Driver check test")
    @Test
    public void testDriverValidation(){
        driver = new Driver("113345","999888","John Smyth");
        dv = new DriverValidation();
        assertEquals(false,dv.driverCheck(driver));

    }
    @DisplayName("Driver is Valid test")
    @Test
    public void testDriverIsValid() throws JsonProcessingException {
        driver = new Driver("111111","222222","John Smyth");
        customer = new Customer(123456,"John","Walsh","sample@mail.com"," 2 test street","Dublin","H78 J9K6");
        label = new Label(customer);
        dv = new DriverValidation();
        Label.labelList.add(driver.getOrderId());

        assertEquals(true,dv.isValidId(driver));

    }
}
