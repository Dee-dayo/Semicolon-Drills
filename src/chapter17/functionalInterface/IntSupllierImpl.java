package chapter17.functionalInterface;

import java.util.function.IntSupplier;

public class IntSupllierImpl {
    public static void main(String[] args) {
        IntSupplier intsupplier = () -> 15;
        System.out.println(intsupplier.getAsInt());
    }
}
