package goepoliticalZoneTest;

import geopoliticalZone.GeopoliticalZone;
import geopoliticalZone.GeopoliticalZoneCheck;
import org.junit.jupiter.api.Test;


import static geopoliticalZone.GeopoliticalZone.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GeopoliticalZoneTest {
    @Test
    public void thereAreSixGeopoliticalZones() {
        assertEquals(6, GeopoliticalZone.values().length);
    }

    @Test
    public void thereAreStatesInAZone() {
        String[] expected = {"Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateau"};
        assertArrayEquals(expected, GeopoliticalZone.NORTH_CENTRAL.getStates());
    }

    @Test
    public void testThatUserCanEnterAState() {
        assertEquals(SOUTH_WEST, GeopoliticalZoneCheck.checkZone("Lagos"));
    }

    @Test
    public void testThatUserCanEnterAnotherState() {
        assertEquals(NORTH_CENTRAL, GeopoliticalZoneCheck.checkZoneTakeTwo("Benue"));
    }

    @Test
    public void testThatUserCanEnterAnotherSecondState() {
        assertEquals(NORTH_WEST, GeopoliticalZoneCheck.checkZoneTakeThree("Kano"));
    }
}
