package drillsTest;

import org.junit.jupiter.api.Test;

import static drills.FireDrill.maxMinDifference;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HighestMinTest {

    @Test
    public void testFunctionWorks(){
        int[] actual = {2, 1, 3, 4, 8};
        int[] result = {7};
        assertArrayEquals(result, maxMinDifference(actual));
    }
}
