package TicTacToeTest;

import org.junit.jupiter.api.AfterEach;
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
        FillTicTacToe [][] actual = ticTacToe2.checkBoard();
        FillTicTacToe [][] expected = new FillTicTacToe[3][3];

        for (FillTicTacToe[] objects : expected) {
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

    @Test
    public void testGameCanCheckIfFinished(){
        ticTacToe2.play(1, 1);
        ticTacToe2.play(2, 2);
        assertFalse(ticTacToe2.isGameEnd());
    }

    @Test
    public void testGameThrowExceptionIfPositionAlreadyFixed(){
        ticTacToe2.play(1, 1);
        ticTacToe2.play(1, 2);
        assertThrows(InvalidInputException.class, ()-> ticTacToe2.play(1, 1));
    }

    @Test
    public void testGameEndAfterAllIndexFilled(){
        assertFalse(ticTacToe2.isGameEnd());
        ticTacToe2.play(1, 1);
        ticTacToe2.play(1, 2);
        ticTacToe2.play(2, 2);
        ticTacToe2.play(1, 3);
        ticTacToe2.play(2, 3);
        ticTacToe2.play(2, 1);
        ticTacToe2.play(3, 1);
        ticTacToe2.play(3,3);
        ticTacToe2.play(3, 2);
        assertTrue(ticTacToe2.isGameEnd());
    }

    @Test
    public void testGameCheckWinnerWhenGameEnds(){
        ticTacToe2.play(1, 1);
        ticTacToe2.play(2, 1);
        ticTacToe2.play(3, 1);
        ticTacToe2.play(1, 2);
        ticTacToe2.play(2, 2);
        ticTacToe2.play(3, 2);
        ticTacToe2.play(3, 3);
        ticTacToe2.play(1,3);
        ticTacToe2.play(2, 3);

        assertTrue(ticTacToe2.isGameEnd());
        assertEquals(1, ticTacToe2.checkWinner());
    }

    @Test
    public void testGameCanCheckIfItsADraw(){
        ticTacToe2.play(1, 1);
        ticTacToe2.play(1, 2);
        ticTacToe2.play(2, 2);
        ticTacToe2.play(1, 3);
        ticTacToe2.play(2, 3);
        ticTacToe2.play(2, 1);
        ticTacToe2.play(3, 1);
        ticTacToe2.play(3,3);
        ticTacToe2.play(3, 2);
        assertEquals(0, ticTacToe2.checkWinner());
    }


}
