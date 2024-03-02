package ticTacToe;

public class Player {
    private int id;

    public Player(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void playGame(TicTacToe ticTacToe, int rowPosition, int columnPosition){
        ticTacToe.markBoard(id, rowPosition,columnPosition);
    }
}
