package drills;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

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
        return Math.max(first, second);
    }


    public static String reverseString(String actual) {
        String word = "";
        StringBuilder reversed = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();


        for(int index = 0; index < actual.length(); index++){
            char character = actual.charAt(index);

            if (!(character == ' ')) reversed.append(character);
            else {
                words.add(reversed.toString());
                reversed = new StringBuilder();
            }
        }
        words.add(reversed.toString());

        for (int i = words.size()-1; i >= 0; i--) {
            word += words.get(i) + " ";
        }

        return word.strip();
    }


    public static boolean wordPangram(String sentence) {
        sentence = sentence.toLowerCase();

        boolean[] alphabetPresent = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            if (Character.isLetter(ch)) {
                int index = ch - 'a';
                alphabetPresent[index] = true;
            }
        }

        for (boolean isPresent : alphabetPresent) {
            if (!isPresent) {
                return false;
            }
        }
        return true;
    }

    public static int[] numberPosition(int[] actual) {
        int[] actualCopy = actual.clone();
        int[] result = new int[actual.length];
        Arrays.sort(actualCopy);

        for(int index = 0; index < actual.length; index++){
            for(int count =0; count < actualCopy.length; count++){
                if (actual[index] == actualCopy[count]) result[index] = count+1;
            }
        }

        return result;
    }

    public static int addition(int num1, int num2) {
        return -(-num1) - (-num2);
    }

    public static StringBuilder occurringNumbers(int[] actual) {
        StringBuilder result = new StringBuilder();
        int counter = 0;

        for(int index = 0; index < actual.length; index++){
            for(int count = 0; count < actual.length; count++){
                if (actual[index] == actual[count]) {
                    counter++;
                }
            }
            result.append(actual[index]).append(":").append(counter).append(", ");
            counter = 0;
        }

        return result;
    }
}
