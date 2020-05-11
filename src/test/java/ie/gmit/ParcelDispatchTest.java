package ie.gmit;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

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

    @DisplayName("Testing parcel dispatch")
    @Test
    void testRegisterParcelDispatchedSuccess(){
        ArrayList<Driver>dispatchedList = new ArrayList<>();
        ArrayList<String>readyToDispatchList = new ArrayList<>();
        driver = new Driver("123456","777777","Sam Smyth");
        readyToDispatchList.add("123456");
        dispatchedList.add(driver);
        readyToDispatchList.remove("123456");
        assertEquals(0,readyToDispatchList.size());
        assertEquals("123456",dispatchedList.get(0).getOrderId());
    }

    @Test
    void testRegisterParcelDispatchedFail(){
        ArrayList<Driver>dispatchedList = new ArrayList<>();
        ArrayList<String>readyToDispatchList = new ArrayList<>();
        pd = new ParcelDispatch();
        driver = new Driver("123456","777777","Sam Smyth");
        readyToDispatchList.add("567456");
        dispatchedList.add(driver);
        readyToDispatchList.remove(pd.searchOrder("123456"));
        assertEquals(1,readyToDispatchList.size());
        assertEquals(1,dispatchedList.size());
    }


    @DisplayName("Testing parcel ready to dispatch")
    @Test
    void testRegisterParcelReadyToDispatch(){
        List<String> labelList = new ArrayList<>();
        ArrayList<String>readyToDispatchList = new ArrayList<>();
        // ParcelDispatch pd = new ParcelDispatch();
        labelList.add("888777");
        readyToDispatchList.add(labelList.get(0));
        //readyToDispatchList.add(labelList.get(1));
        assertEquals("888777",readyToDispatchList.get(0));
    }

    @DisplayName("Testing search order")
    @Test
    void testSearchOrder(){

    }

    @DisplayName("Testing search dispatched")
    @Test
    void testSearchDispatched(){

    }
}
