package chapter17.functionalInterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorImpl {
    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = (x) -> x.toUpperCase();
        System.out.println(unaryOperator.apply("Hello"));
    }
}
