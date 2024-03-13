import java.util.Arrays;

public class MinMax {

    public static int[] minMaxIs(int [] numbers){
        return new int[] {Arrays.stream(numbers).sum() - Arrays.stream(numbers).max().getAsInt(),
            Arrays.stream(numbers).sum() - Arrays.stream(numbers).min().getAsInt()};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 5, 4};
        System.out.println(Arrays.toString(MinMax.minMaxIs(numbers)));
    }
}
