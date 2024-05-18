package chapter15drills;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Chapter15DrillTest {

    @Test
    public void testTransactionAmount() throws IOException {
        String location = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15drills\\transacts.json";
        BigDecimal expectedAmount = new BigDecimal("15000");

        assertEquals(expectedAmount, Drills.totalTransactions(location));
    }

    @Test
    public void testReadsNumberOfDigits() throws IOException {
        String location = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15drills\\test.txt";

        assertEquals(2, Drills.totalNumberOfDigits(location));
    }

    @Test
    public void testCountsNumberOfSentences() throws IOException {
        String location = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15drills\\test2.txt";

        assertEquals(3, Drills.totalNumberOfSentence(location));
    }

}