package turtleGraphicTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import turtleGraphic.Position;
import turtleGraphic.Turtle;
import turtleGraphic.SketchBoard;

import static org.junit.jupiter.api.Assertions.*;
import static turtleGraphic.Direction.*;

public class TurtleGraphicTest {
    private Turtle turtle;
    private SketchBoard sketchboard;

    @BeforeEach
    public void initialiseTurtle(){
        turtle = new Turtle();
        sketchboard = new SketchBoard();
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

    @Test
    public void turtleInitialPositionIsZeroZero(){
        assertEquals(new Position(0,0), turtle.checkPosition());
    }

    @Test
    public void turtleMovesFivePositionWhenTurtleFacingEast_PositionChanges(){
        assertEquals(EAST, turtle.checkDirection());
        assertEquals(new Position(0,0), turtle.checkPosition());
        turtle.move(5, sketchboard);
        assertEquals(new Position(0,4), turtle.checkPosition());
    }

    @Test
    public void turtleMovesFivePositionWhenTurtleFacingSouth_PositionChanges(){
        turtle.turnRight();
        assertEquals(SOUTH, turtle.checkDirection());
        turtle.move(5, sketchboard);
        assertEquals(new Position(4,0), turtle.checkPosition());
    }

    @Test
    public void turtleMoveEast_MoveSouth_MoveWest(){
        assertEquals(new Position(0,0), turtle.checkPosition());
        turtle.move(5, sketchboard);
        turtle.turnRight();
        turtle.move(5, sketchboard);
        turtle.turnRight();
        turtle.move(5, sketchboard);
        assertEquals(new Position(4,0), turtle.checkPosition());
    }

    @Test
    public void turtleMoveEast_MoveSouth_MoveWest_MoveNorth(){
        assertEquals(new Position(0,0), turtle.checkPosition());
        turtle.move(5, sketchboard);
        turtle.turnRight();
        turtle.move(5, sketchboard);
        turtle.turnRight();
        turtle.move(5, sketchboard);
        assertEquals(new Position(4,0), turtle.checkPosition());
        turtle.turnRight();
        turtle.move(5, sketchboard);
        assertEquals(new Position(0,0), turtle.checkPosition());
    }

    @Test
    public void sketchboardHasSizeOf20by20(){
        int[][] expected = new int[20][20];
        assertArrayEquals(expected, sketchboard.getBoard());
    }

    @Test
    public void penIsDown_facingEast_turtleMoves_sketchBoardHas1sOnMovement(){
        turtle.penDown();
        assertFalse(turtle.isPenUp());
        assertEquals(EAST, turtle.checkDirection());
        turtle.move(5, sketchboard);
        assertEquals(new Position(0,4), turtle.checkPosition());

        int[][] expected = sketchboard.getBoard();
        assertEquals(1, expected[0][0]);
        assertEquals(1, expected[0][1]);
        assertEquals(1, expected[0][2]);
        assertEquals(1, expected[0][3]);
        assertEquals(1, expected[0][4]);
        assertEquals(0, expected[0][5]);
    }

     @Test
    public void penIsUp_turtleMoveFive_scoreBoardNotMarked(){
        assertTrue(turtle.isPenUp());
        assertEquals(EAST, turtle.checkDirection());
        turtle.move(5, sketchboard);
        assertEquals(new Position(0,4), turtle.checkPosition());
        int[][] expected = sketchboard.getBoard();
        assertEquals(0, expected[0][0]);
        assertEquals(0, expected[0][1]);
        assertEquals(0, expected[0][2]);
        assertEquals(0, expected[0][3]);
        assertEquals(0, expected[0][4]);
    }

    @Test
    public void penIsDown_facingEast_turtleMoves_sketchBoardMark_faceSouth_move_sketchBoardMark(){
        turtle.penDown();
        turtle.move(5, sketchboard);
        assertEquals(new Position(0,4), turtle.checkPosition());
        int[][] expected = sketchboard.getBoard();
        assertEquals(1, expected[0][4]);

        turtle.turnRight();
        assertEquals(SOUTH, turtle.checkDirection());
        turtle.move(5, sketchboard);
        assertEquals(new Position(4, 4), turtle.checkPosition());
        int[][] expected2 = sketchboard.getBoard();
        assertEquals(1, expected2[0][4]);
        assertEquals(1, expected2[1][4]);
        assertEquals(1, expected2[2][4]);
        assertEquals(1, expected2[3][4]);
        assertEquals(1, expected2[4][4]);
    }

    @Test
    public void turtleGraphicCanDisplayWithHash(){
        turtle.penDown();
        turtle.move(5, sketchboard);
        sketchboard.displayBoard();
    }

    @Test
    public void turtleGraphicCanSquareWithHash(){
        turtle.penDown();
        turtle.move(5, sketchboard);
        turtle.turnRight();
        turtle.move(5, sketchboard);
        turtle.turnRight();
        turtle.move(5, sketchboard);
        turtle.turnRight();
        turtle.move(5, sketchboard);
        sketchboard.displayBoard();
    }
}
