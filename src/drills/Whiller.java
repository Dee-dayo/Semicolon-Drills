package drills;

import java.util.Scanner;

public class Whiller {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int smallest = 0;
        int largest = 0;

        int count = 0;

        do {
            System.out.println("Enter a number ");
            smallest = input.nextInt();
        } while (count < 10); {
            System.out.println("Enter a number: ");
            int another = input.nextInt();

            if (another < smallest) {
                smallest = another;
            }
            if (another > smallest && another < largest){
                largest = another;
            }
            count++;
        }
    }
}
