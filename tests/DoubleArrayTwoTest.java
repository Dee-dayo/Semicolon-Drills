import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleArrayTwoTest {
    @Test
    public void testTheFunctionCanMultiplyElementsByTwo(){
        int[] sample = {2, 3, 4};
        int[] expected = {4, 6, 8};
        assertArrayEquals(expected, DoubleArrayTwo.timesElementsbyTwo(sample));
    }

    @Test
    public void testTheFunctionCanCreateTwiceTheArrayLength(){
        int[] sample = {2, 3, 4};
        assertEquals(6, DoubleArrayTwo.doubleArrayLength(sample));
    }

    @Test
    public void testTheArrayCanBeSwappedtoBiggerArray(){
        int[] sample = {2, 3, 4};
        int [] expected = {2, 3, 4, 0, 0, 0};
        assertArrayEquals(expected, DoubleArrayTwo.swapArray(sample));
    }

    @Test
    public void testTheArrayCanJoinTwoArrays(){
        int[] sample = {2, 3, 4};
        int[] result = DoubleArrayTwo.timesElementsbyTwo(sample);
        int [] expected = {2, 3, 4, 0, 0, 0};
    }
}
