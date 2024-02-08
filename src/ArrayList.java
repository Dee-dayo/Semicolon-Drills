public class ArrayList {
    private boolean isEmpty = true;
    private int numberOfElements;

    private String[] elements = new String[3];

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public void add(String element) {
        if (numberOfElements == elements.length) {
            String[] temp = new String[elements.length * 2];
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
}
