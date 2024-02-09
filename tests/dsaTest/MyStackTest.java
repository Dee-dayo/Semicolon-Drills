package dsaTest;

import dsa.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    private MyStack myStack;
    @BeforeEach
    public void createStack(){
        myStack = new MyStack(3);
    }


    @Test
    public void testNewStackIsEmpty() {
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void addOneElementIntoStack() {
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void addOneElement_removeOneElement(){
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.pop();
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void addTwoElements_removeOne_stackNotEmpty() {
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.push(4);
        myStack.pop();
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void stackIsEmpty_popElement_throwsException(){
        assertTrue(myStack.isEmpty());
        assertThrows(IllegalArgumentException.class, ()-> myStack.pop());
    }

    @Test
    public void addFourElementIntoStack_throwsException(){
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        assertThrows(StackOverflowError.class, ()->myStack.push(2));
    }

    @Test
    public void addThreeElement_popElement_displaysElementPopped(){
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        assertEquals(3, myStack.pop());
    }

    @Test
    public void addThreeElement_popTwo_displayLastPopped(){
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        myStack.pop();
        assertEquals(4, myStack.pop());
    }

    @Test
    public void canCheckLastPushedElement(){
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.push(4);
        assertEquals(4, myStack.peek());

        myStack.pop();
        assertEquals(5, myStack.peek());
    }

    @Test
    public void addTwoElements_pop_peekElement(){
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.push(4);

        myStack.pop();
        assertEquals(5, myStack.peek());
    }

    @Test
    public void countNumberOfElementsInStack(){
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.push(4);

        assertEquals(2, myStack.count());
    }

    @Test
    public void pushThreeElements_popOne_pushOne_peekElement(){
        assertTrue(myStack.isEmpty());
        myStack.push(5);
        myStack.push(4);
        myStack.push(3);
        assertEquals(3, myStack.peek());

        myStack.pop();
        assertEquals(4, myStack.peek());

        myStack.push(10);
        assertEquals(10, myStack.peek());
    }
}
