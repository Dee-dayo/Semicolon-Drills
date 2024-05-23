package chapter15drills;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Chapter15DrillTest {

    @Test
    public void testTransactionAmount() throws IOException {
        String location = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15drills\\transacts.json";
        BigDecimal expectedAmount = new BigDecimal("30000");

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

    @Test
    public void testMethodReturnsTransactionsOfDay(){
        List<Transaction> expected = Drills.dailyTransaction(LocalDate.of(2022, 4, 14));
        assertEquals(2, expected.size());
    }

    @Test
    public void testMethodReturnsTransactionsOfDay2(){
        List<Transaction> expected = Drills.dailyTransaction(LocalDate.of(2022, 7, 17));
        assertEquals(1, expected.size());
    }

    @Test
    public void testMethodReturnsTransactionsBetweenEachPeriod(){
        List<Transaction> expected = Drills.transactionBetweenPeriod(LocalDate.of(2022, 6, 10), LocalDate.of(2022, 7, 20));
        assertEquals(2, expected.size());
    }

    @Test
    public void testMethodReturnsAverageTransactionAmountBetweenEachPeriod() throws IOException {
        BigDecimal expected = Drills.averageTransactionAmountBetweenPeriod(LocalDate.of(2022, 6, 10), LocalDate.of(2022, 7, 20));
        assertEquals(BigDecimal.valueOf(7500.0), expected);
    }
}