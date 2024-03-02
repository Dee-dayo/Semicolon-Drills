package TicTacToeTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ticTacToe.Player;
import ticTacToe.TicTacToe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeEach
    public void initializeGame(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void testTicTacToeGameExist(){
        assertNotNull(ticTacToe);
    }

    @Test
    public void testTicTacToeHasTwoPlayers(){
        Player[] players = ticTacToe.getPlayers();
        int numberOfPlayers = players.length;
        assertEquals(2, numberOfPlayers);
    }

    @Test
    public void testTicTacToeBoardFIlledWithEmpty(){

    }
}
