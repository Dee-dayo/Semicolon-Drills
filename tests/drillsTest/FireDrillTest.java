package drillsTest;

import drills.FireDrill;
import org.junit.jupiter.api.Test;

import static drills.FireDrill.yearCalculator;
import static org.junit.jupiter.api.Assertions.*;

public class FireDrillTest {
    @Test
    public void methodTakesArrayReturnArrayOfOnesAndZeros(){
        int [] actual = {4,5,8,8,8,2,9};
        int[] expected = {0,1,0,0,0,0,1};
        assertArrayEquals(expected, FireDrill.returnOneAndZeroList(actual));
    }

    @Test
    public void testThatItWorksAgain() {
        assertArrayEquals(new int[] {0, 1, 1, 0, 0, 0, 1},FireDrill.returnOneAndZeroList(new int[] {14, 51, 9, 8, 4, 10, 11}));
    }

    @Test
    public void secondTakeOnMethod() {
        int [] actual = {4,5,8,8,8,2,9};
        int[] expected = {0,1,0,0,0,0,1};
        assertArrayEquals(expected, FireDrill.secondAttemptReturnOneAndZero(actual));
    }

    @Test
    public void methodTakesArrayReturnBooleanAray() {
        int [] actual = {4,5,8,8,8,2,9};
        boolean[] expected = {false, true, false, false, false, false, true};
        assertArrayEquals(expected, FireDrill.returnTrueAndFalseList(actual));
    }

    @Test
    public void secondTakeOnSecondMethod() {
        int [] actual = {4,5,8,8,8,2,9};
        boolean[] expected = {false, true, false, false, false, false, true};
        assertArrayEquals(expected, FireDrill.secondAttemptReturnTrueAndFalse(actual));
    }

    @Test
    public void testYearCalculator() {
        assertEquals(1, yearCalculator("12/12/2022"));
    }

    @Test
    public void testFunctionReturnsHighestProduct(){
        int[] actual = {-8};
        assertEquals(-8, FireDrill.highestProduct(actual));
    }

    @Test
    public void testFunctionReturnsForNegative(){
        int[] actual = {1, 5, 10, 4, 0};
        assertEquals(50, FireDrill.highestProduct2(actual));
    }

    @Test
    public void testFunctionReturnsReverse(){
        String actual = "It is still a beautiful world";
        String expected = "world beautiful a still is It";
        assertEquals(expected, FireDrill.reverseString(actual));
    }

    @Test
    public void testFunctionShowsPosition(){
        int[] actual = {10, 3, 6};
        int[] expected = {3, 1, 2};
        int[] answer = FireDrill.numberPosition(actual);
        assertArrayEquals(expected, answer);
    }

    @Test
    public void testFunctionChecksIfWordContainsAllAphabeth(){
        String actual = "the quick brown fox jumps over the lazy dog";
        assertTrue(FireDrill.wordPangram(actual));
    }


}
