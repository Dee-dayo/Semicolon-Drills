package TicTacToeTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ticTacToe.InvalidInputException;
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
        for (TicTacValue[] ticTacValues : expected) {
            Arrays.fill(ticTacValues, TicTacValue.EMPTY);
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

    @Test
    public void testPlayerOneCantPlayIfBoardIsFilledAlready(){
        Player[] players = ticTacToe.getPlayers();
        Player playerOne = players[0];

        playerOne.playGame(ticTacToe,2, 2);
        assertEquals(TicTacValue.X, ticTacToe.getBoard()[1][1]);

        assertThrows(InvalidInputException.class, ()-> playerOne.playGame(ticTacToe, 2, 2));
    }

    @Test
    public void testPlayerTwoCanPlayGame(){
        Player[] players = ticTacToe.getPlayers();
        Player playerTwo = players[1];

        playerTwo.playGame(ticTacToe,2, 2);

//        System.out.println(Arrays.deepToString(ticTacToe.getBoard()));

        assertEquals(TicTacValue.O, ticTacToe.getBoard()[1][1]);
    }

    @Test
    public void testPlayerCantPlayAtInvalidPosition(){
        Player[] players = ticTacToe.getPlayers();
        Player playerOne = players[0];

        assertThrows(InvalidInputException.class, ()-> playerOne.playGame(ticTacToe,5, 9));
    }

    @Test
    public void testGameEndWhenBoardFilled(){
        Player[] players = ticTacToe.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];

        assertFalse(ticTacToe.isGameEnd());

        playerOne.playGame(ticTacToe, 1, 1);
        playerTwo.playGame(ticTacToe, 1, 2);
        playerOne.playGame(ticTacToe, 2, 2);
        playerTwo.playGame(ticTacToe, 1, 3);
        playerOne.playGame(ticTacToe, 2, 3);
        playerTwo.playGame(ticTacToe, 2, 1);
        playerOne.playGame(ticTacToe, 3, 1);
        playerTwo.playGame(ticTacToe, 3, 3);
        playerOne.playGame(ticTacToe, 3, 2);

        assertTrue(ticTacToe.isGameEnd());
    }

    @Test
    public void testGameCheckWinnerWenGameEnds(){
        Player[] players = ticTacToe.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];
        assertFalse(ticTacToe.isGameEnd());

        playerOne.playGame(ticTacToe, 1, 1);
        playerTwo.playGame(ticTacToe, 2, 1);
        playerOne.playGame(ticTacToe, 3, 1);
        playerTwo.playGame(ticTacToe, 1, 2);
        playerOne.playGame(ticTacToe, 2, 2);
        playerTwo.playGame(ticTacToe, 3, 2);
        playerOne.playGame(ticTacToe, 3, 3);
        playerTwo.playGame(ticTacToe, 1,3);
        playerOne.playGame(ticTacToe, 2, 3);

        assertEquals(TicTacValue.X, ticTacToe.checkWinner());
    }

    @Test
    public void testGameCheckGameEndWithDraw(){
        Player[] players = ticTacToe.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];

        playerOne.playGame(ticTacToe, 1, 1);
        playerTwo.playGame(ticTacToe, 1, 2);
        playerOne.playGame(ticTacToe, 2, 2);
        playerTwo.playGame(ticTacToe, 1, 3);
        playerOne.playGame(ticTacToe, 2, 3);
        playerTwo.playGame(ticTacToe, 2, 1);
        playerOne.playGame(ticTacToe, 3, 1);
        playerTwo.playGame(ticTacToe, 3, 3);
        playerOne.playGame(ticTacToe, 3, 2);

        assertEquals(TicTacValue.EMPTY, ticTacToe.checkWinner());
    }

//    @Test
//    public void testGameCheckWinnerPlayerTwoWins(){
//        Player[] players = ticTacToe.getPlayers();
//        Player playerOne = players[0];
//        Player playerTwo = players[1];
//
//        playerOne.playGame(ticTacToe, 1, 1);
//        playerTwo.playGame(ticTacToe, 1, 2);
//        playerOne.playGame(ticTacToe, 1, 3);
//        playerTwo.playGame(ticTacToe, 2, 2);
//        playerOne.playGame(ticTacToe, 2, 1);
//        playerTwo.playGame(ticTacToe, 3, 3);
//        playerOne.playGame(ticTacToe, 2, 3);
//        playerTwo.playGame(ticTacToe, 3, 2);
//
//        System.out.println(Arrays.deepToString(ticTacToe.getBoard()));
//
//        assertEquals(TicTacValue.O, ticTacToe.checkWinner());
//
//
//    }

    @Test
    public void testGameEndsWhenAWinnerIsAlreadyHad(){
        Player[] players = ticTacToe.getPlayers();
        Player playerOne = players[0];
        Player playerTwo = players[1];
        assertFalse(ticTacToe.isGameEnd());

        playerOne.playGame(ticTacToe, 3, 1);
        playerTwo.playGame(ticTacToe, 2, 1);
        playerOne.playGame(ticTacToe, 2, 2);
        playerTwo.playGame(ticTacToe, 1, 1);
        playerOne.playGame(ticTacToe, 1, 3);

        assertTrue(ticTacToe.isGameEnd());
    }
}