package chapter17.functionalInterface;

import java.util.function.ToIntFunction;

public class ToIntFunctionImpl {
    public static void main(String[] args) {
        ToIntFunction<String> toIntFunction = String::length;
        System.out.println(toIntFunction.applyAsInt("Dayo"));
    }
}
