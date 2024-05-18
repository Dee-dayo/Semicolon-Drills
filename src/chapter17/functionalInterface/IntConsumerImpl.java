package chapter17.functionalInterface;

import java.util.function.IntConsumer;

public class IntConsumerImpl {
    public static void main(String[] args) {
        IntConsumer intConsumer = System.out::println;
        intConsumer.accept(89);
    }
}
