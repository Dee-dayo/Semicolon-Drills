package chapter17.functionalInterface;

import java.util.function.Supplier;

public class SupplierImpl {

    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 5;
        System.out.println(supplier.get());
    }
}
