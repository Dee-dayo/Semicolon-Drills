package drillsTest;

import org.junit.jupiter.api.Test;

import static drills.BackToSenderLogistics.calculateRidersPayment;
import static drills.BackToSenderLogistics.calculateRidersPaymentTakeTwo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackToSenderTest {

    @Test
    public void backToSenderTest() {
        assertEquals(9_000, calculateRidersPayment(25));
    }

    @Test
    public void backToSenderTest2() {
        assertEquals(16_000, calculateRidersPayment(55));
    }

    @Test
    public void backToSenderTest3() {
        assertEquals(20_500, calculateRidersPayment(62));
    }

    @Test
    public void backToSenderTest4() {
        assertEquals(45_000, calculateRidersPayment(80));
    }

    @Test
    public void backToSenderTest5() {
        assertEquals(9_000, calculateRidersPaymentTakeTwo(25));
    }
}
