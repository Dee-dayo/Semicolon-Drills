package chapter17.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Example13 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 2, 5, 4, 4, 6, 7, 8, 2, 10);
        System.out.println(numbers.stream().map((number) -> number + "").collect(Collectors.joining(",", "[", "]")));
   //first map it to string, use the collector to join, using , as separator, stat with [ and end with ]
    }
}
