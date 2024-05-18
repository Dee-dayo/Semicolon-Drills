package chapter17.functionalInterface;

import java.util.function.Consumer;

public class ConsumerImpl {
    public static void main(String[] args) {
        Consumer<String> consumer = (word)->{
            System.out.println(word);
        };
        consumer.accept("Hello World");
    }
}
