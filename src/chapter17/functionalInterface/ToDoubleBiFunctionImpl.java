package chapter17.functionalInterface;

import java.util.function.ToDoubleBiFunction;

public class ToDoubleBiFunctionImpl {
    public static void main(String[] args) {
        ToDoubleBiFunction<Integer, String> toDoubleBiFunction = (number, name) -> number + name.length();
        System.out.println(toDoubleBiFunction.applyAsDouble(12, "Dayo"));
    }
}
