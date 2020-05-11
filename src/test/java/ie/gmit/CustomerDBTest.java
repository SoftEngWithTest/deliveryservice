package ie.gmit;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDBTest {
    CustomerDB customerDB;
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

    @DisplayName("Checking Customer Already Exists")
    @Test
    void testAlreadyExists() {
        customerDB = new CustomerDB();
        myCustomer = new Customer();

        // Setting customer's ID to an ID that already exists in the DB
        myCustomer.setCustomerID(334456);
        assertEquals(true, customerDB.existsAlready(myCustomer));
    }

    @DisplayName("Checking Customer Doesn't Exist")
    @Test
    void testDoesNotExist() {
        customerDB = new CustomerDB();
        myCustomer = new Customer();

        myCustomer.setCustomerID(111111);
        assertEquals(false, customerDB.existsAlready(myCustomer));
    }

    @DisplayName("Checking updateDB method")
    @Test
    void testUpdateDB() {
        customerDB = new CustomerDB();
        myCustomer = new Customer();
        ArrayList<Long> DB;
        boolean result = false;

        myCustomer.setCustomerID(111111);
        customerDB.updateDB(myCustomer);
        DB = customerDB.getCustomerDB();
        for (Long ID : DB) {
            if(ID == myCustomer.getCustomerID()) {
                result = true;
            }
        }
        assertEquals(true, result);
    }
}
