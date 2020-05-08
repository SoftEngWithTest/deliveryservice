package ie.gmit;

import org.junit.jupiter.api.*;

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
        myCustomer = new Customer("john", "green", "johngreen@gmail.com", "47 Farrow Road", "Kerry", "T67 K9R5");
        myLabel = new Label(myCustomer);
    }
}
