package ie.gmit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class dummyTest {
    dummyClass dC;

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

    @DisplayName("Checking Constructor Initialisation Success")
    @Test
    void testConstructorSuccess() {
        dC = new dummyClass();
        assertEquals(1, dC.getI());
    }

    @Test
    void test() {
        int a = 0;

        assertEquals(0, a);
    }
}
