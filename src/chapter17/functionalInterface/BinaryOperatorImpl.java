package chapter17.functionalInterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorImpl {
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        System.out.println(binaryOperator.apply(2, 3));
    }
}
