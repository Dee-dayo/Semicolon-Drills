package drills;

import java.time.LocalDate;
import java.time.Period;

public class FireDrill {
    public static int[] returnOneAndZeroList(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];

        for (int index = 0; index < inputArray.length; index++) {
            if (inputArray[index] % 2 == 0) outputArray[index] = 0;
            else outputArray[index] = 1;
        }
        return outputArray;
    }

    public static int[] secondAttemptReturnOneAndZero(int[] inputArray) {
        for(int index = 0; index < inputArray.length; index++){
            inputArray[index] = inputArray[index] % 2;
        }
        return inputArray;
    }

    public static boolean[] returnTrueAndFalseList(int[] inputArray) {
        boolean[] outputArray = new boolean[inputArray.length];
        for (int index = 0; index < inputArray.length; index++) {
            outputArray[index] = inputArray[index] % 2 != 0;
        }
        return outputArray;
    }

    public static boolean[] secondAttemptReturnTrueAndFalse(int[] inputArray) {
        boolean[] outputArray = new boolean[inputArray.length];
        for (int index = 0; index < inputArray.length; index++) {
            if (inputArray[index] % 2 == 0) outputArray[index] = false;
            else outputArray[index] = true;
        }
        return outputArray;
    }

    public static int[] anotherMethod() {
        return new int [10];
    }

    public static int yearCalculator(String dateOfBirth) {
        LocalDate currentDate = LocalDate.now() ;
       String [] split = dateOfBirth.split("/");
        LocalDate inputDate = LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]));
        Period period = Period.between(inputDate, currentDate);
        return period.getYears();
    }

}
