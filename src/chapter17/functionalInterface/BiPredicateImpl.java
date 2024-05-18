package chapter17.functionalInterface;

import java.util.function.BiPredicate;

public class BiPredicateImpl {

    public static void main(String[] args) {
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a < b;
        System.out.println(biPredicate.test(1, 2));
    }
}
