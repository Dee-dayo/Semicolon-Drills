package chapter16;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        return second.getName().compareTo(first.getName());
    }
}
