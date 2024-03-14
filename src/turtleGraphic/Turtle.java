package turtleGraphic;

import static turtleGraphic.Direction.*;

public class Turtle {
    private boolean isPenUp = true;
    private Direction currentDirection = EAST;
    private Position currentPosition = new Position(0, 0);


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
        return currentDirection;
    }


    public void turnLeft() {
       currentDirection = currentDirection.turnLeft();
    }

    public void turnRight() {
        currentDirection = currentDirection.turnRight();
    }

    public Position checkPosition() {
        return currentPosition;
    }

    public void move(int numberOfSteps, SketchBoard sketchBoard) {
        if (!isPenUp) drawOnBoard(sketchBoard, numberOfSteps);

        switch (currentDirection) {
            case EAST -> moveEastward(numberOfSteps);
            case SOUTH -> moveSouthward(numberOfSteps);
            case WEST -> moveWestWard(numberOfSteps);
            case NORTH -> moveNorthWard(numberOfSteps);
        }
    }

    private void drawOnBoard(SketchBoard sketchBoard, int numberOfSteps) {
        int[][] floorBoard = sketchBoard.getBoard();

        switch (currentDirection) {
            case EAST -> markEastWard(floorBoard, numberOfSteps);
            case SOUTH -> markSouthWard(floorBoard, numberOfSteps);
            case WEST -> markWestWard(floorBoard, numberOfSteps);
        }
    }

    private void markWestWard(int[][] floorBoard, int numberOfSteps) {
        int row = currentPosition.getCurrentRow();
        int column = currentPosition.getCurrentColumn();

        for (int rowIndex = numberOfSteps - 1; rowIndex >= 0; rowIndex--) {
            floorBoard[row ]
        }
    }

    private void markSouthWard(int[][] floorBoard, int numberOfSteps) {
        int row = currentPosition.getCurrentRow();
        int column = currentPosition.getCurrentColumn();

        for (int columnIndex = 0; columnIndex < numberOfSteps; columnIndex++) {
                floorBoard[row + columnIndex][column] = 1;
            }
    }

    private void markEastWard(int[][] floorBoard, int numberOfSteps) {
        int row = currentPosition.getCurrentRow();
        int column = currentPosition.getCurrentColumn();

        for (int rowIndex = 0; rowIndex < numberOfSteps; rowIndex++) {
                floorBoard[row][column + rowIndex] = 1;
            }
    }

    private void moveNorthWard(int numberOfSteps) {
        currentPosition = new Position(numberOfSteps - currentPosition.getCurrentRow() - 1, currentPosition.getCurrentColumn());
    }

    private void moveWestWard(int numberOfSteps) {
        currentPosition = new Position(currentPosition.getCurrentRow(), numberOfSteps - currentPosition.getCurrentColumn() - 1);
    }

    private void moveSouthward(int numberOfSteps) {
        currentPosition = new Position(currentPosition.getCurrentRow() + numberOfSteps - 1, currentPosition.getCurrentColumn());
    }

    private void moveEastward(int numberOfSteps) {
        currentPosition = new Position(currentPosition.getCurrentRow(), currentPosition.getCurrentColumn() + numberOfSteps - 1);
    }

}
