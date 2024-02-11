package dsa;

public class ArrayList {
    private boolean isEmpty = true;
    private int numberOfElements;

    private String[] elements = new String[3];

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public void add(String element) {
        if (numberOfElements == elements.length) {
            String[] temp = new String[elements.length + 1];
            int tempCounter = 0;

            for (int i = 0; i < elements.length; i++){
                temp[tempCounter] = elements[i];
                tempCounter++;
            }
            temp[tempCounter] = element;
            elements = temp;

        }

        elements[numberOfElements] = element;
        numberOfElements++;
        isEmpty = false;
    }

    public void remove(String element) {
        if (numberOfElements == 0) throw new ArrayIndexOutOfBoundsException("Out of Bound");

        String[] temp = new String[elements.length];
        int tempCounter = 0;

        for (int index = 0; index < numberOfElements; index++) {
            if (elements[index].equals(element)) continue;
            temp[tempCounter] = elements[index];
            tempCounter++;
        }
        elements = temp;
        numberOfElements--;
    }

    public String get(int index) {
        if (index >= 0 && index < elements.length) {
            return elements[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Out of Range");
        }
    }

    public int get(String element) {
        for (int i = 0; i < elements.length; i++) {
            if (element.equalsIgnoreCase(elements[i])) return i;
        }
        return 0;
    }

    public int size() {
        return numberOfElements;
    }

    public void add(int index, String element) {

        if (index < 0 || index > numberOfElements) throw new ArrayIndexOutOfBoundsException("Out of bound");

        if (numberOfElements == elements.length) {
            String[] temp = new String[elements.length + 1];

            for (int count = 0; count < elements.length; count++) {
                temp[count] = elements[count];
            }
            elements = temp;
        }

        for (int i = numberOfElements; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        numberOfElements++;
    }

    public boolean contain(String element) {
        for (int index = 0; index < numberOfElements; index++) {
            if (elements[index].equalsIgnoreCase(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String element) {
        for (int index = 0; index < numberOfElements; index++) {
            if (elements[index].equalsIgnoreCase(element)) return index;
        }
        return -1;
    }

    public int lastIndexOf(String element) {
        for (int index = numberOfElements - 1; index >= 0; index--) {
            if (elements[index].equalsIgnoreCase(element)) return index;
        }
        return -1;
    }

    public String[] toArray() {
        String [] newArray = new String[numberOfElements];
        for (int index = 0; index < numberOfElements; index++) {
            newArray[index] = elements[index];
        }
        return newArray;
    }

    public void set(int position, String element) {
        elements[position] = element;
    }

    public void clear() {
        numberOfElements = 0;
        this.elements = new String[3];
    }
}
