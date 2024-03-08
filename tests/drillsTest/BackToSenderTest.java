package drillsTest;

import org.junit.jupiter.api.Test;
import ticTacToe.InvalidInputException;

import static drills.BackToSenderLogistics.calculateRidersPayment;
import static drills.BackToSenderLogistics.calculateRidersPaymentTakeTwo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BackToSenderTest {

    @Test
    public void testNoOfDeliveriesLessThank50() {
        assertEquals(9_000, calculateRidersPayment(25));
    }

    @Test
    public void testNoOfDeliveriesLessThan59() {
        assertEquals(16_000, calculateRidersPayment(55));
    }

    @Test
    public void testNoOfDeliveriesLessThan69() {
        assertEquals(20_500, calculateRidersPayment(62));
    }

    @Test
    public void testNoOfDeliveriesLessThan100() {
        assertEquals(45_000, calculateRidersPayment(80));
    }

    @Test
    public void testNoOfDeliveriesLessThank50TakeTwo() {
        assertEquals(9_000, calculateRidersPaymentTakeTwo(25));
    }

    @Test
    public void testNoOfDeliveriesLessThan100TakeTwo() {
        assertEquals(45_000, calculateRidersPaymentTakeTwo(80));
    }

    @Test
    public void testFunctionThrowsExceptionIfNoDeliveriesIsNegative(){
        assertThrows(InvalidInputException.class, ()->calculateRidersPayment(-10));
    }

    @Test
    public void testFunctionThrowsExceptionIfNoDeliveriesIsGreaterThan100(){
        assertThrows(InvalidInputException.class, ()->calculateRidersPayment(109));
    }
}
