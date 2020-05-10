package ie.gmit;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LabelTest {
    Label myLabel;
    Customer myCustomer;

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

    @DisplayName("Testing Generate Label")
    @Test
    void testGenerateLabel() {
        myCustomer = new Customer(888888, "john", "green", "johngreen@gmail.com", "47 Farrow Road", "Kerry", "T67 K9R5");
        myLabel = new Label(myCustomer);
    }

    @DisplayName("Testing Unique ID Getter & Setter")
    @Test
    void testGetSetID() {
        myCustomer = new Customer(888888, "john", "green", "johngreen@gmail.com", "47 Farrow Road", "Kerry", "T67 K9R5");
        myLabel = new Label(myCustomer);

        myLabel.setUniqueID(989767);
        assertEquals(989767, myLabel.getUniqueID());
    }

    @DisplayName("Testing Order ID list Getter & Setter")
    @Test
    void testGetSetOrderIDList() {
        ArrayList<Long> orderIDList = new ArrayList<>();
        myCustomer = new Customer(888888, "john", "green", "johngreen@gmail.com", "47 Farrow Road", "Kerry", "T67 K9R5");
        myLabel = new Label(myCustomer);

        orderIDList = myLabel.getOrderIDList();
        orderIDList.add((long) 666777);
        myLabel.setOrderIDList(orderIDList);

        assertEquals(orderIDList, myLabel.getOrderIDList());
    }
}
