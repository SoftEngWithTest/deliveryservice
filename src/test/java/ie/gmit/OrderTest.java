package ie.gmit;
import org.junit.jupiter.api.*;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class OrderTest {

    Order order;
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

    @DisplayName("Order ID success test")
    @Test
    void testOrderIdSuccess(){
        order = new Order("123888");
        assertEquals("123888",order.getOrderId());
    }

    @DisplayName("Order ID fail test")
    @Test
    void testOrderIdFail(){
        assertThrows(IllegalArgumentException.class,()->new Order("1234"));
    }


}