package chapter17.functionalInterface;

import java.util.function.BiFunction;

public class BiFunctionImpl {
    public static void main(String[] args) {
        BiFunction<String, Integer, Boolean> biFunction = (word, number) -> word.length() == number;

        System.out.println(biFunction.apply("jagaban", 7));
    }
}
