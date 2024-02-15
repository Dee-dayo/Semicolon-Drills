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
}
