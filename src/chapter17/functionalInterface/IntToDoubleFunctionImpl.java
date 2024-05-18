package chapter17.functionalInterface;

import java.util.function.IntToDoubleFunction;

public class IntToDoubleFunctionImpl {
    public static void main(String[] args) {
        IntToDoubleFunction intToDoubleFunction = (number) -> number * 2;
        System.out.println(intToDoubleFunction.applyAsDouble(10));
    }
}
