package chapter17.functionalInterface;

import java.util.function.DoubleFunction;

public class DoubleFunctionImpl {
    public static void main(String[] args) {
        DoubleFunction<Double> doubleFunction = (number) -> number * number;
        System.out.println(doubleFunction.apply(5d));

    }
}
