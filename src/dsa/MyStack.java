package dsa;

public class MyStack {

    private int numberOfElements;
    private int size;
    private int[] elements;

    public MyStack(int size) {
        this.size = size;
        this.elements = new int[size];
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public void push(int element) {
        if (isFull()) throw new StackOverflowError("Stack is Full");
        elements[numberOfElements] = element;
        numberOfElements++;
    }

    private boolean isFull() {
        return size == numberOfElements;
    }

    public int pop() {
        if (numberOfElements == 0) throw new IllegalArgumentException("Stack is Empty");
        numberOfElements--;
        return elements[numberOfElements];
    }

    public int peek() {
        return elements[numberOfElements - 1];

    }

    public int count() {
        return numberOfElements;
    }
}
