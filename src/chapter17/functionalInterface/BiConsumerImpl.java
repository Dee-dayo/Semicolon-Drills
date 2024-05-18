package chapter17.functionalInterface;

import java.util.function.BiConsumer;

public class BiConsumerImpl {
    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + " " + b);
        biConsumer.accept("Hello", "World");
    }
}
