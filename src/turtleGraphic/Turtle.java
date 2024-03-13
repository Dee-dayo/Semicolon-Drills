package turtleGraphic;

import static turtleGraphic.Direction.*;

public class Turtle {
    private boolean isPenUp = true;
    private Direction direction = EAST;

    public boolean isPenUp() {
        return isPenUp;
    }

    public void penDown() {
        isPenUp = false;
    }

    public void penUp() {
        isPenUp = true;
    }

    public Direction checkDirection() {
        return direction;
    }


    public void turnLeft() {
       direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }
}
