package chapter17.functionalInterface;

import java.util.function.DoubleSupplier;

public class DoubleSupplierImpl {
    public static void main(String[] args) {
        DoubleSupplier doubleSupplier = () -> 10;
        System.out.println(doubleSupplier.getAsDouble());
    }
}
