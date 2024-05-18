package chapter17.functionalInterface;

import java.util.function.ToIntBiFunction;

public class ToIntBiFunctionImpl {
    public static void main(String[] args) {
        ToIntBiFunction<Integer, Integer> function = (a, b) -> a * b;
        System.out.println(function.applyAsInt(14, 3));
    }
}
