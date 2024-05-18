package chapter17.functionalInterface;

import java.util.function.IntToLongFunction;

public class IntToLongFunctionImpl {
    public static void main(String[] args) {
        IntToLongFunction intToDoubleFunction = (number) -> number * 200000000L;
        System.out.println(intToDoubleFunction.applyAsLong(3));
    }
}
