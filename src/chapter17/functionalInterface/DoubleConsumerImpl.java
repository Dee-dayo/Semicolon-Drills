package chapter17.functionalInterface;

import java.util.function.DoubleConsumer;

public class DoubleConsumerImpl {
    public static void main(String[] args) {
        DoubleConsumer consumer = System.out::println;
        consumer.accept(90d);
    }
}
