package turtleGraphic;

public class SketchBoard {
    private int[][] sketchboard = new int[20][20];
    public int[][] getBoard() {
        return sketchboard;
    }

    public void displayBoard() {
        for (int row=0; row<20; row++) {
            for (int col=0; col<20; col++) {
                if (sketchboard[row][col] == 0) System.out.print("  ");
                if (sketchboard[row][col] == 1) System.out.print("# ");
            }
            System.out.println();
        }
    }
}
