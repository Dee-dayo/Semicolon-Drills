package dsa;

public class MySet {
    private boolean isEmpty = true;
    private int noOfElements;
    private String[] elements;

    public MySet() {
        elements = new String[5];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void add(String element) {
        if (elements.length == noOfElements) {
            String[] temp = new String[noOfElements + 1];
            int tempCounter = 0;

            for (int i = 0; i < elements.length; i++){
                temp[tempCounter] = elements[i];
                tempCounter++;
            }
            temp[tempCounter] = element;
            elements = temp;
        }
        elements[noOfElements] = element;
        isEmpty = false;
        noOfElements++;
    }

    public int size() {
        return noOfElements;
    }

    public void remove(String element) {
        if (!isEmpty) {
            noOfElements--;
        } else {
            throw new ArrayIndexOutOfBoundsException("Set is empty");
        }
    }

    public boolean contain(String element) {
        for (int index = 0; index < noOfElements; index++) {
            if (elements[index].equalsIgnoreCase(element)) {
                return true;
            }
        }
        return false;
    }
}
