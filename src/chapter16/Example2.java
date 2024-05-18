package chapter16;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Example2 {
    public static void main(String[] args) {
        Comparator<String> comparator = (a, b) -> b.compareTo(a);  //this changes the order to descending
        Map<String, Integer> map = new TreeMap<>(comparator);  //treemap is ordered, hashmap is unordered
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);

        System.out.println(map);
    }
}
