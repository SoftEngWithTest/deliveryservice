package ie.gmit;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class ParcelDispatchTest {
    Driver driver;
    ParcelDispatch pd;

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

    @DisplayName("Testing parcel ready to dispatch")
    @Test
    void testRegisterParcelReadyToDispatch(){
        driver = new Driver("123456","777777","Sam Smyth");
        pd = new ParcelDispatch();
        pd.readyToDispatchList.add(driver.getOrderId());
        pd.registerParcelReadyToDispatch();
        assertEquals("123456",pd.readyToDispatchList.get(0));
    }

    @DisplayName("Testing search order")
    @Test
    void testSearchOrder(){
        driver = new Driver("000777","555666","John");
        pd = new ParcelDispatch();
        pd.readyToDispatchList.add("000777");
      pd.searchOrder(driver.getOrderId());
      assertEquals(true,pd.orderMatch);
      pd.searchOrder("123456");
      assertEquals(false,pd.orderMatch);
    }

    @DisplayName("Testing search dispatched")
    @Test
    void testSearchDispatched(){
        driver = new Driver("333444","555666","John");
        pd = new ParcelDispatch();
        pd.dispatchedList.add(driver);
        assertEquals("333444",pd.searchDispatched(driver.getOrderId()));
    }

    @Test
    void testSearchDispatchedFail(){
        driver = new Driver("333444","555666","John");
        pd = new ParcelDispatch();
        pd.dispatchedList.add(driver);
        assertEquals(null,pd.searchDispatched("777888"));
    }

    @DisplayName("Testing dispatched list")
    @Test
    void testDispatchedList(){
        driver = new Driver("000777","555666","John");
        pd = new ParcelDispatch();
        pd.registerParcelDispatched(driver);
        assertEquals(1,pd.dispatchedList.size());
    }
}
