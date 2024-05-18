package chapter17.functionalInterface;

import java.util.function.ToLongFunction;

public class ToLongFunctionImpl {
    public static void main(String[] args) {
        ToLongFunction<Integer> toLongFunction = (number) -> number * 3;
        System.out.println(toLongFunction.applyAsLong(13));
    }
}
