package ticTacToeSecondTake;
import ticTacToe.InvalidInputException;
import java.util.Arrays;
import static ticTacToeSecondTake.TicTacToeGameTest.print;

public class TicTacToe2 {
    private final FillTicTacToe[][] ticTacToeTable;
    private final int players;
    private int currentPlayer = 1;
    private boolean isGameEnd = false;


    public TicTacToe2() {
        ticTacToeTable = new FillTicTacToe[3][3];
        for (FillTicTacToe[] objects : ticTacToeTable) {
            Arrays.fill(objects, FillTicTacToe.EMPTY);
        }

        players = 2;
    }

    public FillTicTacToe[][] checkBoard() {
        return ticTacToeTable;
    }

    public int noOfPlayers() {
        return players;
    }

    public void play(int rowNumber, int columnNumber) {
        if (rowNumber >= 1 && rowNumber <= 3 && columnNumber >= 1 && columnNumber <= 3) {
            if (ticTacToeTable[rowNumber - 1][columnNumber - 1] == FillTicTacToe.EMPTY) {
                if (currentPlayer == 1) {
                    ticTacToeTable[rowNumber - 1][columnNumber - 1] = FillTicTacToe.X;
                    currentPlayer = 2;
                } else {
                    ticTacToeTable[rowNumber - 1][columnNumber - 1] = FillTicTacToe.O;
                    currentPlayer = 1;
                }

                int winner = checkWinner();
                if (winner != 0) isGameEnd = true;
                else checkGameEnd();

            } else throw new InvalidInputException("Position already filled");
        } else throw new InvalidInputException("Board has only 3 rows and 3 columns");
    }


    private void checkGameEnd() {
        for (FillTicTacToe[] fillTicTacToes : ticTacToeTable) {
            for (int count = 0; count < ticTacToeTable.length; count++) {
                if (fillTicTacToes[count] == FillTicTacToe.EMPTY) return;
            }
        }
        isGameEnd = true;
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public int checkWinner() {
        for (int row = 0; row < 3; row++) {
            if (ticTacToeTable[row][0] == ticTacToeTable[row][1] && ticTacToeTable[row][0] == ticTacToeTable[row][2]) {
                if (ticTacToeTable[row][0] == FillTicTacToe.X) return 1;
                else return 2;
            }
        }

        for (int column = 0; column < 3; column++) {
            if (ticTacToeTable[0][column] == ticTacToeTable[1][column] && ticTacToeTable[0][column] == ticTacToeTable[2][column]) {
                if (ticTacToeTable[column][0] == FillTicTacToe.X) return 1;
                else return 2;
            }
        }

        if ((ticTacToeTable[0][0] == ticTacToeTable[1][1] && ticTacToeTable[1][1] == ticTacToeTable[2][2]) ||
                (ticTacToeTable[0][2] == ticTacToeTable[1][1] && ticTacToeTable[1][1] == ticTacToeTable[2][0])) {
            if (ticTacToeTable[1][1] == FillTicTacToe.X) {
                return 1;
            } else if (ticTacToeTable[1][1] == FillTicTacToe.O) {
                return 2;
            }
        }
        return 0;
    }

    public void displayBoard() {
        print("===============================");
        for (FillTicTacToe[] fillTicTacToes : ticTacToeTable) {
            for (int column = 0; column < ticTacToeTable.length; column++) {
                System.out.print("| " + fillTicTacToes[column] + " |  ");
            }
            print("");
        }
        print("===============================");
    }
}
