package ticTacToe;

import java.util.Scanner;

public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner input = new Scanner(System.in);

        System.out.println("TIC-TAC-TOE!!!");
        ticTacToe.printBoard();

//        while (!ticTacToe.isGameEnd()){
//            try {
//             ticTacToe.printBoard();
//
//            }
//        }

    }
}