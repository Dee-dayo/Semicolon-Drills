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
        if (rowPosition >= 1 && rowPosition <= 3 && columnPosition >=1 && columnPosition <= 3) {
            if (playerNumber == 1) {

                if (board[rowPosition - 1][columnPosition - 1] == TicTacValue.EMPTY) {
                    board[rowPosition - 1][columnPosition - 1] = TicTacValue.X;
                } else {
                    throw new InvalidInputException("This place is already filled");
                }
            } else {
                if (board[rowPosition - 1][columnPosition - 1] == TicTacValue.EMPTY) {
                    board[rowPosition - 1][columnPosition - 1] = TicTacValue.O;
                } else {
                    throw new InvalidInputException("This place is already filled");
                }
            }
        } else throw new InvalidInputException("Board has only 3 rows & 3 columns");
    }
}
