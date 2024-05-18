package chapter16;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Example {

    public static void main(String[] args) {
        Set<Person> people = new TreeSet<>(new PersonComparator()); //comparator fr custom order, comparable for natural order

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Jane");
        map.put(3, "Doe");

        System.out.println(map.get(1));
    }
}
