package dsa;

public class MySet {
    private boolean isEmpty = true;
    public int noOfElements;
    private String[] elements;

    public MySet() {
        elements = new String[5];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void add(String element) {
        for (int index = 0; index < noOfElements; index++) {
            if (elements[index].equals(element)) return;
        }

        elements[noOfElements] = element;
        isEmpty = false;
        noOfElements++;

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
    }

    public int size() {
        return noOfElements;
    }

    public void remove(String element) {
        if (noOfElements == 0) throw new ArrayIndexOutOfBoundsException("Out of Bound");

        String[] temp = new String[elements.length];
        int tempCounter = 0;

        for (int index = 0; index < noOfElements; index++) {
            if (elements[index].equals(element)) continue;
            temp[tempCounter] = elements[index];
            tempCounter++;
        }
        elements = temp;
        noOfElements--;
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
