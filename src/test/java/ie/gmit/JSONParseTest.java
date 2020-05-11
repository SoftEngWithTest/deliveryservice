package ie.gmit;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JSONParseTest {
    JSONParse myJSONParser;

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

    /*@DisplayName("Checking readJSON Method Success")
    @Test
    void testReadJSON() {
        myJSONParser = new JSONParse();
        myJSONParser.readJSON("customers.json");
    }*/

    /*@DisplayName("Checking readJSON Method File Not Found")
    @Test
    void testReadJSONFileNotFound() {
        myJSONParser = new JSONParse();
        Exception e = assertThrows(FileNotFoundException.class, () -> {
                myJSONParser.readJSON("c.json");
        });
        assertEquals(File Not Found);
    }*/
}
