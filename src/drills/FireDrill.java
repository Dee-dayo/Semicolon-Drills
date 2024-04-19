package drills;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;

public class FireDrill {

    public static int[] maxMinDifference(int[] inputArray){
       int[] result = new int[1];
       int min = inputArray[0];
       int max = inputArray[0];

       for (int index = 0; index < inputArray.length; index++) {
           if (inputArray[index] < min) {
               min = inputArray[index];
           }
           if (inputArray[index] > max) {
               max = inputArray[index];
           }
       }
       result[0] = max - min;
       return result;
    }


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

    public static int highestProduct(int[] actual) {
        if (actual.length == 0) return 0;
        if (actual.length==1) return actual[0];

        int product = Integer.MIN_VALUE;
        for (int row : actual) {
            for (int column : actual) {
                int answer = row * column;
                if (row == column) continue;
                if (answer > product) product = answer;
            }
        }
        return product;
    }

    public static int highestProduct2(int[] actual){
        Arrays.sort(actual);
        int first = actual[0] * actual[1];
        int second = actual[actual.length-1] * actual[actual.length-2];
        return Integer.max(first, second);
    }


}
