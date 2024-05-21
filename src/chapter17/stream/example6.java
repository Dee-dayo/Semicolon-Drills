package chapter17.stream;

import java.util.List;

public class example6 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 4, 2, 11, 3, 4, 1, 9, 8, 1, 10, 2, 6, 7, 5);
        System.out.println(numbers.stream().sorted().toList());


        //distint wud remove duplicates
        System.out.println(numbers.stream().distinct().sorted().toList());
    }
}
