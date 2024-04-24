package sevenSegment;

import ticTacToe.InvalidInputException;

public class SevenSegmentDisplay {

    public static void displayScreen(String number) {
        if (number.length() == 8) {
            String[] num = number.split("");

            if (num[7].equals("1")) {

                if (num[0].equals("1")) System.out.println("######");
                else System.out.println();

                for (int index = 0; index < 2; index++) {
                    if (num[5].equals("1")) System.out.print("#");
                    else System.out.print(" ");
                    if (num[1].equals("1")) System.out.println("    #");
                    else System.out.println();
                }

                if (num[6].equals("1")) System.out.println("######");
                else System.out.println();

                for (int index = 0; index < 2; index++) {
                    if (num[4].equals("1")) System.out.print("#");
                    else System.out.print(" ");
                    if (num[2].equals("1")) System.out.println("    #");
                    else System.out.println(" ");
                }

                if (num[3].equals("1")) System.out.println("######");
                else System.out.println();

            } else throw new SevenSegmentOffException("You didnt switch on the board");

        } else throw new InvalidInputException("Number must be 8 digits long");
    }

    public static void main(String[] args) {
        String display = "11111111";
        displayScreen(display);
    }

}
