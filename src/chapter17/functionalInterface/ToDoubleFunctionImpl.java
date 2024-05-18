package chapter17.functionalInterface;

import java.util.function.ToDoubleFunction;

public class ToDoubleFunctionImpl {
    public static void main(String[] args) {
        ToDoubleFunction<Integer> toDoubleFunction = (number)-> number * 2;
        System.out.println(toDoubleFunction.applyAsDouble(19));
    }
}
