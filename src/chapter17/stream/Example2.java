package chapter17.stream;

import java.util.stream.IntStream;

public class Example2 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).filter((number)->number%2==0).forEach(System.out::println);

        System.out.println(IntStream.rangeClosed(1, 10).filter((number) -> number % 2 == 0).sum());
    }
}
