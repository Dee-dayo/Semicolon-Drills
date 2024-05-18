package chapter17.functionalInterface;

import java.util.function.DoublePredicate;

public class DoublePredicateImpl {
    public static void main(String[] args) {
        DoublePredicate doublePredicate = (number) -> number % 2 == 0;
        System.out.println(doublePredicate.test(12.0));
    }
}
