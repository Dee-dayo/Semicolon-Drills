package chapter17.functionalInterface;

import java.util.function.DoubleToLongFunction;

public class DoubleToLongFunctionImpl {
    public static void main(String[] args) {
        DoubleToLongFunction doubleToLongFunction = (number) -> (long) number;
        System.out.println(doubleToLongFunction.applyAsLong(127329874382987438229847.47293));
    }
}
