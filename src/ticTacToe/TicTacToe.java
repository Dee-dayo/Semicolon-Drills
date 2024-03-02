package ticTacToe;

public class TicTacToe {
    private Player[] players;
    private TicTacValue[][] board;

    public TicTacToe(){
        Player playerOne = new Player(1);
        Player playerTwo = new Player(2);

        players = new Player[2];
        players[0] = playerOne;
        players[1] = playerTwo;

        board = new TicTacValue[3][3];
        for (int counter = 0; counter<board.length; counter++){
            for (int index = 0; index <board[counter].length; index++){
                board[counter][index] = TicTacValue.EMPTY;
            }
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public TicTacValue[][] getBoard() {
        return board;
    }

    public void markBoard(int playerNumber, int rowPosition, int columnPosition) {
        if (playerNumber == 1) {

            if (board[rowPosition - 1][columnPosition - 1] == TicTacValue.EMPTY) {
                board[rowPosition - 1][columnPosition - 1] = TicTacValue.X;
            }

        }

//
    }
}
