package chapter17.functionalInterface;

import java.util.function.IntFunction;

public class IntFunctionImpl {
    public static void main(String[] args) {
        IntFunction<String> intFunction = String::valueOf;
        System.out.println(intFunction.apply(13));
    }
}
