package chapter17.stream;

import java.util.List;
import java.util.stream.IntStream;

public class Example10 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        double average = numbers.stream().flatMapToInt((element)-> IntStream.of(element * 2)).average().orElseThrow();
        System.out.println(average);
    }
}
