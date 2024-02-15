package drills;

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
}
