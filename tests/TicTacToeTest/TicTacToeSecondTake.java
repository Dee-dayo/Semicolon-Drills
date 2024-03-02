package TicTacToeTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ticTacToe.InvalidInputException;
import ticTacToeSecondTake.FillTicTacToe;
import ticTacToeSecondTake.TicTacToe2;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeSecondTake {
    private TicTacToe2 ticTacToe2;

    @BeforeEach
    public void startGame(){
        ticTacToe2 = new TicTacToe2();
    }


    @Test
    public void testGameHas3by3BoardFilledWithEmptyWhenGameIsCreated(){
        Object [][] actual = ticTacToe2.checkBoard();
        Object [][] expected = new Object[3][3];

        for (Object[] objects : expected) {
            Arrays.fill(objects, FillTicTacToe.EMPTY);
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGameHasTwoPlayersWhenStarted(){
        assertEquals(2, ticTacToe2.noOfPlayers());
    }

    @Test
    public void testFirstPlayerCanPlayTheGame(){
        ticTacToe2.play(1, 1);
//        System.out.println(Arrays.deepToString(ticTacToe2.checkBoard()));
        assertEquals(FillTicTacToe.X, ticTacToe2.checkBoard()[0][0]);
    }

    @Test
    public void testFirstPlayerCantPlayToInvalidRowOrColumn(){
        assertThrows(InvalidInputException.class, ()->ticTacToe2.play(4, 5));
    }

    @Test
    public void testSecondPlayerCanPlayTheGame(){
        ticTacToe2.play(1, 1);
        assertEquals(FillTicTacToe.X, ticTacToe2.checkBoard()[0][0]);

        ticTacToe2.play(2, 2);
        assertEquals(FillTicTacToe.O, ticTacToe2.checkBoard()[1][1]);
    }
}
