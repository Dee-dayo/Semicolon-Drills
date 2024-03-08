import java.util.Arrays;

public class DoubleArray {
    public static int[] arrayDouble(int[] myArray) {
        int [] newArray = new int[myArray.length * 2];
        int newArrayCounter = 0;

        for (int index = 0; index < myArray.length; index++) {
            newArray[newArrayCounter] = myArray[index];
            newArrayCounter++;
        }

        for (int index = 0; index < myArray.length; index++) {
            newArray[newArrayCounter] = myArray[index] * 2;
            newArrayCounter++;
        }

        return newArray;
    }

    public static int[] secondTryArrayDouble(int[] inputArray) {
        int[] outputArray = new int[inputArray.length * 2];
        int outputArrayCounter = inputArray.length;

        for (int index = 0; index < inputArray.length; index++) {
            outputArray[index] = inputArray[index];
            outputArray[outputArrayCounter] = inputArray[index] * 2;
            outputArrayCounter++;
        }

        return outputArray;
    }

    public static int[] thirdTryArrayDouble(int[] inputArray) {
        int[] outputArray = new int[inputArray.length * 2];

        for (int index = 0; index < inputArray.length; index++) {
            outputArray[index] = inputArray[index];
            outputArray[index + inputArray.length] = inputArray[index] * 2;
        }

        return outputArray;
    }
}
