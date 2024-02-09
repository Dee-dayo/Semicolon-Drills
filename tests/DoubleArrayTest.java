import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DoubleArrayTest {

    @Test
    public void supplyAnArray_getDoubleFilledWithTheElementsAfter(){
        int [] sampleInput = {4,5,8};
        int [] expected = {4, 5, 8, 8, 10, 16};
        assertArrayEquals(expected, DoubleArray.arrayDouble(sampleInput));
    }

    @Test
    public void supplyAnArrayOfTen_getDoubleFilledWithTwentyElements(){
        int [] sampleInput = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
        int [] expected = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 4, 6, 8, 10, 12, 14, 16, 18, 20, 24};
        assertArrayEquals(expected, DoubleArray.arrayDouble(sampleInput));
    }

    @Test
    public void anotherRevisedFunctionTest(){
        int [] sampleInput = {4,5,8};
        int [] expected = {4, 5, 8, 8, 10, 16};
        assertArrayEquals(expected, DoubleArray.secondTryArrayDouble(sampleInput));
    }

    @Test
    public void yetAnotherRevisedFunctionTest(){
        int [] sampleInput = {4,5,8};
        int [] expected = {4, 5, 8, 8, 10, 16};
        assertArrayEquals(expected, DoubleArray.thirdTryArrayDouble(sampleInput));
    }

}
