package chapter17.functionalInterface;

import java.util.function.ToLongBiFunction;

public class ToLongBiFunctionImpl {
    public static void main(String[] args) {
        ToLongBiFunction<Integer, Integer> toLongBiFunction = (num1, num2) -> num1 + num2;
        System.out.println(toLongBiFunction.applyAsLong(2, 3));
    }
}
