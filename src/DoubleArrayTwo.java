public class DoubleArrayTwo {
    public static int[] timesElementsbyTwo(int[] inputArray){
        for (int index = 0; index < inputArray.length; index++) inputArray[index] = inputArray[index] * 2;
        return inputArray;
    }

    public static int doubleArrayLength(int[] inputArray) {
        return inputArray.length * 2;
    }

    public static int[] swapArray(int[] inputArray) {
        int[] outputArray = new int[doubleArrayLength(inputArray)];
        for (int index = 0; index < inputArray.length; index++) {
            outputArray[index] = inputArray[index];
        }
        return outputArray;
    }

//    public static int[] doubleArrayElements(int[] inputArray) {
//        int[] outputArray = new int[doubleArrayLength(inputArray)];
//
//
//
//    }
}
