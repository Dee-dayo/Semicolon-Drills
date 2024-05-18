package chapter17.functionalInterface;

import java.util.function.ObjLongConsumer;

public class ObjLongCustomerImpl {
    public static void main(String[] args) {
        ObjLongConsumer<String> objLongConsumer = (name, number) -> System.out.println(name);
        objLongConsumer.accept("Hello", 3L);
    }
}
