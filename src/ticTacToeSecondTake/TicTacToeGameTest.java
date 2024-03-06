package ticTacToeSecondTake;

import java.util.Scanner;

public class TicTacToeGameTest {
    private static final TicTacToe2 game = new TicTacToe2();

    public static void main(String[] args) {
        gameApp();
    }

    private static void gameApp() {
        print("""
                Welcome to TIC-TAC-TOE Game!!!
                
                Press 1 to start game
                Press 2 to quit!!!
                """);

        String option = input("");

        switch (option) {
            case "1":
                playGame();
                break;

            case "2":
                exit();
                break;

            default:
                print("Wrong option");
                gameApp();
        }
    }

    private static void playGame() {
        game.displayBoard();
        print("Player 1, make a move");
        String row = input("Enter your desired row number: ");
        String column = input("Enter your desired column number: ");

        try {
            game.play(Integer.parseInt(row), Integer.parseInt(column));
            game.displayBoard();
        } catch (Exception e){
            print(e.getMessage());
        } finally {
            playGame();
        }
    }

    private static void exit() {
        print("See you some other time!!!");
        System.exit(0);
    }

    private static String input(String prompt){
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static void print(String display){
        System.out.println(display);
    }
}
