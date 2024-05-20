package chapter17.stream;

public class Example5 {
    public static void main(String[] args) {
        String word = "Hello World";
        word.chars().forEach(System.out::println);
    }
}
