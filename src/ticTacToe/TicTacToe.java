package ticTacToe;

public class TicTacToe {
    private Player[] players;
    private TicTacValue[][][] board;

    public TicTacToe(){
        Player playerOne = new Player(1);
        Player playerTwo = new Player(2);

        players = new Player[2];
        players[0] = playerOne;
        players[1] = playerTwo;

        board = new TicTacValue[3][3][3];
        for (int counter = 0; counter<board.length; counter++){
            for (int index = 0; index <board[counter].length; index++){
                for (int inner = 0; inner < board[counter][inner].length; inner++){
                    board[counter][index][inner] = TicTacValue.EMPTY;
                }
            }
        }
    }

    public Player[] getPlayers() {
        return players;
    }
}
