package chapter17.stream;

import java.util.List;

public class Example3 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 15, 20, 25, 30, 40, 50, 60, 65, 70, 80, 82, 90);

        numbers.stream().filter((number) -> number % 2 != 0).forEach(System.out::println);
    }
}
