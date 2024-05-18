package chapter17.functionalInterface;

import java.util.function.IntPredicate;

public class IntPredicateImpl {
    public static void main(String[] args) {
        IntPredicate intPredicate = (number) -> number % 2 == 0;
        System.out.println(intPredicate.test(15));
    }
}
