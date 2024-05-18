package chapter17.functionalInterface;

import java.util.function.Predicate;

public class PredicateImpl {

    public static void main(String[] args) {
        Predicate<Integer> predicate = (word) -> word % 2 == 0;
        System.out.println(predicate.test(6));
    }
}
