package chapter17.stream;

import java.util.List;
import java.util.stream.Stream;

public class Example9 {
    public static void main(String[] args) {
        List<List<Integer>> lists = List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(10, 20, 30, 40, 50),
                List.of(100, 200, 300, 400, 500)
        ); //flat map maps from an element to a stream
        System.out.println(lists.stream() //[[1, 2, 3, 4, 5], [10, 20, 30, 40, 50], [100, 200, 300, 400, 500]]
                .flatMap(list -> list.stream()) //first[1, 2, 3, 4, 5], second[10,20,30,40,50]
                .toList());



        List<String> list = List.of("Beejay", "Dayo", "Moh", "Jumoke");
        System.out.println(list.stream().flatMap((element) -> Stream.of(new StringBuilder(element).reverse())).toList());
    }
}
