package chapter17.stream;

import java.util.List;

public class Example8 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 4, 2, 6, 11, 4, 3, 7, 8, 3, 5, 11);

        numbers.stream().map((number)->String.format("number = %d", number)).forEach(System.out::println);
    }
}
