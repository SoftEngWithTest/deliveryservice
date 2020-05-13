package ie.gmit;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

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

    @DisplayName("Checking readJSON Method Success")
    @Test
    void testReadJSON() throws IOException, ParseException {
        myJSONParser = new JSONParse();
        myJSONParser.readJSON("customers.json");
    }
}