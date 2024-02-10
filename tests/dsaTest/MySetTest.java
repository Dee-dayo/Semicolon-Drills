package dsaTest;

import dsa.MySet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    private MySet mySet;

    @BeforeEach
    public void initializeSet() {
        mySet = new MySet();
    }

    @Test
    public void newSetIsEmpty(){
        assertTrue(mySet.isEmpty());
    }

    @Test
    public void elementsCanBeAddedToSet() {
        assertTrue(mySet.isEmpty());

        mySet.add("Beejay");
        assertFalse(mySet.isEmpty());
    }

    @Test
    public void threeElementsCanBeAdded_sizeBecomesThree(){
        assertTrue(mySet.isEmpty());

        mySet.add("Beejay");
        mySet.add("Moh");
        mySet.add("Jumoke");
        assertEquals(3,  mySet.size());
    }

    @Test
    public void threeElementsAdded_oneRemoved_sizeIsTwo() {
        assertTrue(mySet.isEmpty());

        mySet.add("Beejay");
        mySet.add("Moh");
        mySet.add("Jumoke");
        mySet.remove("Jumoke");
        assertEquals(2, mySet.size());
    }

    @Test
    public void setIsEmpty_removeElement_throwsException() {
        assertTrue(mySet.isEmpty());
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> mySet.remove("Beejay"));
    }

    @Test
    public void addThreeElements_checkToSeeIfItContainsElement() {
        assertTrue(mySet.isEmpty());

        mySet.add("Beejay");
        mySet.add("Moh");
        mySet.add("Jumoke");
        assertTrue(mySet.contain("Jumoke"));
        assertTrue(mySet.contain("Beejay"));
    }

    @Test
    public void addTwoElements_checkIfSetContainsElementIgnoreCase() {
        assertTrue(mySet.isEmpty());

        mySet.add("Moh");
        mySet.add("Jumoke");
        assertTrue(mySet.contain("jumoke"));
    }

    @Test
    public void addTwoElements_checkIfSetContainsElement_returnsFalse() {
        assertTrue(mySet.isEmpty());

        mySet.add("Moh");
        mySet.add("Jumoke");
        assertFalse(mySet.contain("Beejay"));
    }

    @Test
    public void canAddSixElementsAndMore() {
        assertTrue(mySet.isEmpty());
        mySet.add("Moh");
        mySet.add("Jumoke");
        mySet.add("Izu");
        mySet.add("Orisha");
        mySet.add("Dayo");
        mySet.add("Victoria");
        assertEquals(6, mySet.size());
    }

    @Test
    public void addSevenElements_removeThree(){
        assertTrue(mySet.isEmpty());
        mySet.add("Moh");
        mySet.add("Jumoke");
        mySet.add("Izu");
        mySet.add("Orisha");
        mySet.add("Dayo");
        mySet.add("Victoria");
        mySet.add("Blessing");
        mySet.remove("Moh");
        mySet.remove("Blessing");
        mySet.remove("Victoria");
        assertEquals(4, mySet.size());
    }

    @Test
    public void cantAddElementIfItAlreadyExists() {
        assertTrue(mySet.isEmpty());
        mySet.add("Beejay");
        mySet.add("Beejay");
        assertEquals(1, mySet.size());
    }

//    @Test
//    public void cannotRemoveElementIfNotFoundInSet() {
//        assertTrue(mySet.isEmpty());
//        mySet.add("Beejay");
//        mySet.add("Moh");
//        assertThrows(IllegalArgumentException.class, ()-> mySet.remove("Jumoke"));
//    }
}
