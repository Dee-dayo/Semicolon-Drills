package ticTacToeSecondTake;

import ticTacToe.InvalidInputException;

import java.util.Arrays;

public class TicTacToe2 {
    private final Object[][] ticTacToeTable;
    private final int players;
    private int currentPlayer = 1;


    public TicTacToe2(){
        ticTacToeTable = new Object[3][3];
        for (Object[] objects : ticTacToeTable) {
            Arrays.fill(objects, FillTicTacToe.EMPTY);
        }

        players = 2;
    }

    public Object[][] checkBoard() {
        return ticTacToeTable;
    }

    public int noOfPlayers() {
        return players;
    }

    public void play(int rowNumber, int columnNumber) {
        if (rowNumber >= 1 && rowNumber <= 3 && columnNumber >= 1 && columnNumber <= 3) {
            if (currentPlayer == 1) {
                if (ticTacToeTable[rowNumber - 1][columnNumber - 1] == FillTicTacToe.EMPTY) {
                    ticTacToeTable[rowNumber - 1][columnNumber - 1] = FillTicTacToe.X;
                    currentPlayer = 2;
                }
            }
            if (currentPlayer == 2) {
                if (ticTacToeTable[rowNumber - 1][columnNumber - 1] == FillTicTacToe.EMPTY) {
                    ticTacToeTable[rowNumber - 1][columnNumber - 1] = FillTicTacToe.O;
                    currentPlayer = 1;
                }
            }
        } else throw new InvalidInputException("Board has only 3 rows and 3 columns");
    }
}
