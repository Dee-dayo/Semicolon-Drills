package chapter17.functionalInterface;

import java.util.function.ObjIntConsumer;

public class ObjIntConsumerImpl {
    public static void main(String[] args) {
        ObjIntConsumer<Integer> objIntConsumer = (number, number2) -> System.out.println(number);
        objIntConsumer.accept(14, 2);
    }
}
