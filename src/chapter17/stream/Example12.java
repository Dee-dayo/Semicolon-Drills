package chapter17.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Example12 {
    public static void main(String[] args) {
        List<Integer> codePoints = List.of(65, 97, 66, 98, 67, 99);
        System.out.println(codePoints.stream().collect(Collectors.toMap((codepoint) -> codepoint, Character::toString)));

        //for cases where we have duplicates, we cant map with key value pair
        List<Integer> numbers = List.of(65, 97, 66, 98, 67, 99, 65);
        System.out.println(numbers.stream().collect(Collectors.toMap((number) -> number, Character::toString, (a, b) -> a)));
    }
}
