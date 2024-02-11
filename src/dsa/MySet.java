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
        if (isEmpty) throw new ArrayIndexOutOfBoundsException("Nothing is in the set");
        boolean found = false;

        for (int index = 0; index < noOfElements; index++) {
            if (elements[index].equals(element)) {
                found = true;
                for (int count = index; count < noOfElements - 1; count++) {
                    elements[count] = elements[count + 1];
                }
                break;
            }
        }

        if (found) {
            noOfElements--;
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

    public boolean containsAll(String... checkElement) {
        for (int index = 0; index < checkElement.length; index++) {
            if (!contain(checkElement[index])) {
                return false;
            }
        }
        return true;
    }

    public void addAll(String... addElements) {
        for (int index = 0; index < addElements.length; index++) {
            if (!contain(addElements[index])) {
                elements[noOfElements] = addElements[index];
                noOfElements++;
            }
        }
    }
}
