package TicTacToeTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ticTacToe.Player;
import ticTacToe.TicTacToe;
import ticTacToe.TicTacValue;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeEach
    public void initializeGame() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void testTicTacToeGameExist() {
        assertNotNull(ticTacToe);
    }

    @Test
    public void testTicTacToeHasTwoPlayers() {
        Player[] players = ticTacToe.getPlayers();
        int numberOfPlayers = players.length;
        assertEquals(2, numberOfPlayers);
    }

    @Test
    public void testTicTacToeBoardFIlledWithEmpty() {
        TicTacValue[][] actual = ticTacToe.getBoard();

        TicTacValue[][] expected = new TicTacValue[3][3];
        for (int counter = 0; counter<expected.length; counter++){
            for (int index = 0; index <expected[counter].length; index++){
                expected[counter][index] = TicTacValue.EMPTY;
            }
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBoardCanBeMarked(){
        Player player = ticTacToe.getPlayers()[0];
        ticTacToe.markBoard(player.getId(), 1,1);

        TicTacValue actual = ticTacToe.getBoard()[0][0];
        assertNotEquals(TicTacValue.EMPTY, actual);
    }

    @Test
    public void testPlayerOneCanPlayGame(){
        Player[] players = ticTacToe.getPlayers();
        Player playerOne = players[0];

        playerOne.playGame(ticTacToe,2, 2);

//        System.out.println(Arrays.deepToString(ticTacToe.getBoard()));

        assertEquals(TicTacValue.X, ticTacToe.getBoard()[1][1]);
    }
}
