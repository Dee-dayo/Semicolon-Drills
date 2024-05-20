package chapter17.stream;

import java.util.List;

public class Example4 {
    public static void main(String[] args) {
        List<String> words = List.of("Dayo", "Bj", "Timilehin", "Moh");
        words.stream().map((word) -> word.length()).forEach(System.out::println);
    }
}
