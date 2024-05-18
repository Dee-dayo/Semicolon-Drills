package chapter17.functionalInterface;

import java.util.function.DoubleUnaryOperator;

public class DoubleUnaryOperatorImpl {
    public static void main(String[] args) {
        DoubleUnaryOperator doubleUnaryOperator = (x) -> x * 2;
        System.out.println(doubleUnaryOperator.applyAsDouble(12.5));
    }
}
