package chapter17.functionalInterface;

import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorImpl {
    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = (a, b) -> a + b;
        System.out.println(intBinaryOperator.applyAsInt(16, 4));
    }
}
