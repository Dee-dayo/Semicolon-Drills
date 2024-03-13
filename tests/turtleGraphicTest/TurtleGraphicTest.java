package turtleGraphicTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import turtleGraphic.Turtle;

import static org.junit.jupiter.api.Assertions.*;
import static turtleGraphic.Direction.*;

public class TurtleGraphicTest {
    private Turtle turtle;

    @BeforeEach
    public void initialiseTurtle(){
        turtle = new Turtle();
    }

    @Test
    public void testPenIsUp(){
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void penIsUpPenCanTurnDown(){
        assertTrue(turtle.isPenUp());

        turtle.penDown();
        assertFalse(turtle.isPenUp());
    }

    @Test
    public void penIsDownPenCanTurnUp(){
        assertTrue(turtle.isPenUp());
        turtle.penDown();
        assertFalse(turtle.isPenUp());
        turtle.penUp();
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void turtleIsFacingEast(){
        assertEquals(EAST, turtle.checkDirection());
    }

    @Test
    public void turtleIsFacingEastCanTurnLeftToNorth(){
        assertEquals(EAST, turtle.checkDirection());
        turtle.turnLeft();
        assertSame(NORTH, turtle.checkDirection());
    }

    @Test
    public void turtleIsFacingNorthCanTurnLeftToWest(){
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(WEST, turtle.checkDirection());
    }

    @Test
    public void turtleIsFacingWestCanTurnLeftToSouth(){
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(SOUTH, turtle.checkDirection());
    }

    @Test
    public void turtleIsFacingSouthCanTurnLeftToEast(){
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(EAST, turtle.checkDirection());
    }

    @Test
    public void turtleIsFacingEastCanTurnRightToSouth(){
        assertEquals(EAST, turtle.checkDirection());
        turtle.turnRight();
        assertSame(SOUTH, turtle.checkDirection());
    }

    @Test
    public void turtleIsFacingSouthCanTurnRightToWest(){
        turtle.turnRight();
        turtle.turnRight();
        assertSame(WEST, turtle.checkDirection());
    }

    @Test
    public void turtleIsFacingWestCanTurnRightToNorth(){
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        assertSame(NORTH, turtle.checkDirection());
    }

    @Test
    public void turtleIsFacingNorthCanTurnRightToEast(){
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        turtle.turnRight();
        assertSame(EAST, turtle.checkDirection());
    }
}
