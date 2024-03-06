package ticTacToe;
import ticTacToeSecondTake.FillTicTacToe;
import java.util.Arrays;

public class TicTacToe {
    private final Player[] players;
    private final TicTacValue[][] board;
    private boolean isGameEnd = false;

    public TicTacToe(){
        Player playerOne = new Player(1);
        Player playerTwo = new Player(2);

        players = new Player[2];
        players[0] = playerOne;
        players[1] = playerTwo;

        board = new TicTacValue[3][3];
        for (TicTacValue[] ticTacValues : board) {
            Arrays.fill(ticTacValues, TicTacValue.EMPTY);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public TicTacValue[][] getBoard() {
        return board;
    }

    public void markBoard(int playerNumber, int rowPosition, int columnPosition) {
        if (rowPosition >= 1 && rowPosition <= 3 && columnPosition >=1 && columnPosition <= 3) {
            if (board[rowPosition - 1][columnPosition - 1] == TicTacValue.EMPTY) {
                if (playerNumber == 1) {
                    board[rowPosition - 1][columnPosition - 1] = TicTacValue.X;
                } else {
                    board[rowPosition - 1][columnPosition - 1] = TicTacValue.O;
                }

                TicTacValue winner = checkWinner();
                if (winner != TicTacValue.EMPTY) isGameEnd = true;
                else checkGameEnd();

            } else {
                throw new InvalidInputException("This place is already filled");
            }
        } else throw new InvalidInputException("Board has only 3 rows & 3 columns");
    }

    public boolean isGameEnd() {
        checkGameEnd();
        return isGameEnd;
    }

    public void checkGameEnd(){
        for (TicTacValue[] ticTacValues : board) {
            for (int column = 0; column < board.length; column++) {
                if (ticTacValues[column] == TicTacValue.EMPTY) return;
            }
        }
        isGameEnd = true;
    }

    public TicTacValue checkWinner() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] && board[row][0] == board[row][2]) {
                if (board[row][0] == TicTacValue.X) return TicTacValue.X;
                else return TicTacValue.O;
            }
        }

        for (int column = 0; column < 3; column++) {
            if (board[0][column] == board[1][column] && board[0][column] == board[2][column]) {
                if (board[column][0] == TicTacValue.X) return TicTacValue.X;
                else return TicTacValue.O;
            }
        }

        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            if (board[1][1] == TicTacValue.X) {
                return TicTacValue.X;
            } else return TicTacValue.O;
        }

        return TicTacValue.EMPTY;
    }
}