package chapter17.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Example11 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(19, 2, 3, 2, 5, 8, 23, 12);
        System.out.println(numbers.stream().filter((number) -> number % 2 == 0).collect(Collectors.toList()));
    }
}
