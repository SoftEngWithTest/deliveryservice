package ie.gmit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {
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

    @DisplayName("Checking Default Constructor Initialisation")
    @Test
    void testDefaultConstructor() {
        myCustomer = new Customer();
        assertEquals(0, myCustomer.getCustomerID());
        assertEquals("", myCustomer.getFirstName());
        assertEquals("", myCustomer.getLastName());
        assertEquals("", myCustomer.getEmail());
        assertEquals("", myCustomer.getAddress());
        assertEquals("", myCustomer.getCounty());
        assertEquals("", myCustomer.getEircode());
    }

    @DisplayName("Checking Constructor Initialisation Success")
    @Test
    void testConstructorSuccess() {
        myCustomer = new Customer(999999, "ruairi", "doherty", "rdoherty@gmail.com",
                "22 High Street", "Galway", "H77 K8Y9");
        assertEquals("ruairi", myCustomer.getFirstName());
        assertEquals("doherty", myCustomer.getLastName());
        assertEquals("rdoherty@gmail.com", myCustomer.getEmail());
        assertEquals("22 High Street", myCustomer.getAddress());
        assertEquals("Galway", myCustomer.getCounty());
        assertEquals("H77 K8Y9", myCustomer.getEircode());
    }

    @DisplayName("Checking For Invalid First Name Entry")
    @Test
    void testInvalidFirstNameEntry() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            myCustomer = new Customer(777777, "r", "doherty", "rdoherty@gmail.com",
            "22 High Street", "Galway", "H77 K8Y9");
        });
        assertEquals("First name must be at least 2 characters", e.getMessage());
    }

    @DisplayName("Checking For Invalid Last Name Entry")
    @Test
    void testInvalidLastNameEntry() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            myCustomer = new Customer(666666, "ruairi", "d", "rdoherty@gmail.com",
                    "22 High Street", "Galway", "H77 K8Y9");
        });
        assertEquals("Last name must be at least 2 characters", e.getMessage());
    }

    @DisplayName("Checking For Invalid Email Entry")
    @Test
    void testInvalidEmailEntry() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            myCustomer = new Customer(577777, "ruairi", "doherty", "@gmail.",
                    "22 High Street", "Galway", "H77 K8Y9");
        });
        assertEquals("Email must be at least 10 characters", e.getMessage());
    }

    @DisplayName("Checking For Invalid Address Entry")
    @Test
    void testInvalidAddressEntry() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            myCustomer = new Customer(678989, "ruairi", "doherty", "rdoherty@gmail.com",
                    "22", "Galway", "H77 K8Y9");
        });
        assertEquals("Address must be at least 5 characters", e.getMessage());
    }

    @DisplayName("Checking For Invalid County Entry")
    @Test
    void testInvalidCountyEntry() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            myCustomer = new Customer(976865, "ruairi", "doherty", "rdoherty@gmail.com",
                    "22 High Street", "G", "H77 K8Y9");
        });
        assertEquals("County must be at least 4 characters", e.getMessage());
    }

    @DisplayName("Checking For Invalid Eircode Entry (Insufficient Characters)")
    @Test
    void testInvalidEircodeEntry1() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            myCustomer = new Customer(6456897, "ruairi", "doherty", "rdoherty@gmail.com",
                    "22 High Street", "Galway", "H77");
        });
        assertEquals("Eircode must be 8 characters", e.getMessage());
    }

    @DisplayName("Checking For Invalid Eircode Entry (Incorrect Format)")
    @Test
    void testInvalidEircodeEntry2() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            myCustomer = new Customer(4567548, "ruairi", "doherty", "rdoherty@gmail.com",
                    "22 High Street", "Galway", "H77 9999");
        });
        assertEquals("Eircode must follow the correct format e.g H78 J9K6", e.getMessage());
    }
}
