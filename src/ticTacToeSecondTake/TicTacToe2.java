package ticTacToeSecondTake;

import ticTacToe.InvalidInputException;

import java.util.Arrays;

public class TicTacToe2 {
    private final FillTicTacToe[][] ticTacToeTable;
    private final int players;
    private int currentPlayer = 1;
    private boolean gameStatus = false;


    public TicTacToe2(){
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
            if (currentPlayer == 1) {
                if (ticTacToeTable[rowNumber - 1][columnNumber - 1] == FillTicTacToe.EMPTY) {
                    ticTacToeTable[rowNumber - 1][columnNumber - 1] = FillTicTacToe.X;
                    currentPlayer = 2;
                }
                else throw new InvalidInputException("Position already filled");
            } else if (currentPlayer == 2) {
                if (ticTacToeTable[rowNumber - 1][columnNumber - 1] == FillTicTacToe.EMPTY) {
                    ticTacToeTable[rowNumber - 1][columnNumber - 1] = FillTicTacToe.O;
                    currentPlayer = 1;
                }
                else throw new InvalidInputException("Position already filled");
            }
        } else throw new InvalidInputException("Board has only 3 rows and 3 columns");
    }

    private void checkGameEnd(){
        for(int index = 0; index < ticTacToeTable.length; index++){
            for (int count = 0; count < ticTacToeTable.length; count++){
                if (ticTacToeTable[index][count] == FillTicTacToe.EMPTY){
                    return;
                }
            }
        }
        gameStatus = true;
    }

    public boolean isGameEnd() {
        checkGameEnd();
        return gameStatus;
    }

    public int checkWinner(){
        for (int row = 0; row < 3; row++){
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
                return 1; // Player 1 wins
            } else if (ticTacToeTable[1][1] == FillTicTacToe.O) {
                return 2; // Player 2 wins
            }
        }
        return 0;
    }

    public void resetGame() {
        for (FillTicTacToe[] row : ticTacToeTable) {
            Arrays.fill(row, FillTicTacToe.EMPTY);
        }
        currentPlayer = 1;
        gameStatus = false;
    }
}


//    public int checkWinner() {
//        // Check rows
//        for (int i = 0; i < 3; i++) {
//            if (ticTacToeTable[i][0] == ticTacToeTable[i][1] && ticTacToeTable[i][1] == ticTacToeTable[i][2]) {
//                if (ticTacToeTable[i][0] == FillTicTacToe.X) {
//                    return 1; // Player 1 wins
//                } else if (ticTacToeTable[i][0] == FillTicTacToe.O) {
//                    return 2; // Player 2 wins
//                }
//            }
//        }
//
//        // Check columns
//        for (int i = 0; i < 3; i++) {
//            if (ticTacToeTable[0][i] == ticTacToeTable[1][i] && ticTacToeTable[1][i] == ticTacToeTable[2][i]) {
//                if (ticTacToeTable[0][i] == FillTicTacToe.X) {
//                    return 1; // Player 1 wins
//                } else if (ticTacToeTable[0][i] == FillTicTacToe.O) {
//                    return 2; // Player 2 wins
//                }
//            }
//        }
//
//        // Check diagonals
//        if ((ticTacToeTable[0][0] == ticTacToeTable[1][1] && ticTacToeTable[1][1] == ticTacToeTable[2][2]) ||
//                (ticTacToeTable[0][2] == ticTacToeTable[1][1] && ticTacToeTable[1][1] == ticTacToeTable[2][0])) {
//            if (ticTacToeTable[1][1] == FillTicTacToe.X) {
//                return 1; // Player 1 wins
//            } else if (ticTacToeTable[1][1] == FillTicTacToe.O) {
//                return 2; // Player 2 wins
//            }
//        }
//
//        return 0; // No winner yet
//    }
//
//    public boolean isGameEnd() {
//        int winner = checkWinner();
//        if (winner != 0) {
//            gameStatus = true; // Game ends if there's a winner
//            return true;
//        }
//
//        // Check for draw
//        boolean draw = true;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (ticTacToeTable[i][j] == FillTicTacToe.EMPTY) {
//                    draw = false;
//                    break;
//                }
//            }
//            if (!draw) {
//                break;
//            }
//        }
//        if (draw) {
//            gameStatus = true; // Game ends in a draw
//        }
//
//        return gameStatus;
//    }
//}
