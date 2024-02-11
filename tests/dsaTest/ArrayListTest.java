package dsaTest;

import dsa.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    private ArrayList myStringArray;

    @BeforeEach
    public void initializeArray(){
        myStringArray = new ArrayList();
    }

    @Test
    public void ArrayListIsEmpty(){
        assertTrue(myStringArray.isEmpty());
    }

    @Test
    public void ArrayListIsEmpty_ElementCanBeAdded(){
        assertTrue(myStringArray.isEmpty());

        myStringArray.add("Bolaji");
        assertFalse(myStringArray.isEmpty());
    }

    @Test
    public void ArrayListISEmpty_TwoElementsCanBeAdded(){
        assertTrue(myStringArray.isEmpty());

        myStringArray.add("Bolai");
        myStringArray.add("Mohammed");
        assertFalse(myStringArray.isEmpty());
    }

    @Test
    public void addOneElement_removeElement_listIsEmpty(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Bolaji");
        assertFalse(myStringArray.isEmpty());

        myStringArray.remove("Bolaji");
        assertTrue(myStringArray.isEmpty());
    }

    @Test
    public void addTwoElement_removeOne_listNotEmpty(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Bolaji");
        myStringArray.add("Moh");

        myStringArray.remove("Bolaji");
        assertFalse(myStringArray.isEmpty());
    }

    @Test
    public void removeElementFromEmptyList_throwException(){
        assertTrue(myStringArray.isEmpty());
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->myStringArray.remove("Moh"));
    }

    @Test
    public void addOneElement_getByIndex_returnElement(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Bolaji");
        assertEquals("Bolaji", myStringArray.get(0));
    }

    @Test
    public void addTwoElements_getByIndex_returnElement(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");

        assertEquals("Beejay", myStringArray.get(1));
        assertEquals("Moh", myStringArray.get(0));
    }

    @Test
    public void addOneElement_getByElement_returnIndex(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Bolaji");
        assertEquals(0, myStringArray.get("Bolaji"));
    }

    @Test
    public void addTwoElements_getByElements_returnIndex(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");

        assertEquals(1, myStringArray.get("Beejay"));
        assertEquals(0, myStringArray.get("Moh"));
    }

    @Test
    public void addThreeElements_removeMiddleElement_elementThreeMovesToTwo(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        myStringArray.add("Jumoke");
        assertEquals(1, myStringArray.get("Beejay"));

        myStringArray.remove("Beejay");
        assertEquals(1, myStringArray.get("Jumoke"));
    }

    @Test
    public void addThreeElements_removeFirstTwo_element3MovesTo1(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        myStringArray.add("Jumoke");
        assertEquals(2, myStringArray.get("Jumoke"));

        myStringArray.remove("Beejay");
        myStringArray.remove("Moh");
        assertEquals(0, myStringArray.get("Jumoke"));
    }

    @Test
    public void addElement_getWithCaseIgnore_returnIndex(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        myStringArray.add("Jumoke");

        assertEquals(1, myStringArray.get("beejay"));
        assertEquals(2, myStringArray.get("JUMOKE"));
    }

    @Test
    public void addOneElement_getWrongIndex_THrowException(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Bolaji");

        assertEquals("Bolaji", myStringArray.get(0));
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->myStringArray.get(5));
    }

    @Test
    public void canAddFiveElementsInList(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Bolaji");
        myStringArray.add("Moh");
        myStringArray.add("Jumoke");
        myStringArray.add("Orisha");
        myStringArray.add("Izu");

        assertEquals(0, myStringArray.get("Bojaji"));
        assertEquals(1, myStringArray.get("Moh"));
        assertEquals(2, myStringArray.get("Jumoke"));
        assertEquals(3, myStringArray.get("Orisha"));
        assertEquals(4, myStringArray.get("Izu"));
    }

    @Test
    public void canAddFiveElements_getElementByIndex(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Bolaji");
        myStringArray.add("Moh");
        myStringArray.add("Jumoke");
        myStringArray.add("Orisha");
        myStringArray.add("Izu");

        assertEquals("Orisha", myStringArray.get(3));
    }

    @Test
    public void addFiveElements_RemoveTwo_listReNumbers(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Bolaji");
        myStringArray.add("Moh");
        myStringArray.add("Jumoke");
        myStringArray.add("Orisha");
        myStringArray.add("Izu");

        myStringArray.remove("Izu");
        myStringArray.remove("Jumoke");

        assertEquals(0, myStringArray.get("Bolaji"));
        assertEquals(1, myStringArray.get("Moh"));
        assertEquals(2, myStringArray.get("Orisha"));
    }

    @Test
    public void addTwoElements_getlistSize(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");

        assertEquals(2, myStringArray.size());
    }

    @Test
    public void addFourElements_getListSize(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        myStringArray.add("Jumoke");
        myStringArray.add("Orisha");

        assertEquals(4, myStringArray.size());
    }

    @Test
    public void addFourElements_removeTwo_getListSize(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        myStringArray.add("Jumoke");
        myStringArray.add("Orisha");

        myStringArray.remove("Moh");
        myStringArray.remove("Beejay");
        assertEquals(2, myStringArray.size());
    }

    @Test
    public void listIsEmpty_canInsertElementInFirstIndex(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.insert(0, "Moh");
        assertEquals("Moh", myStringArray.get(0));
    }

    @Test
    public void hasOneElement_canInsertInIndexZero(){
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        assertEquals(0, myStringArray.get("moh"));

        myStringArray.insert(0, "Beejay");
        assertEquals(0, myStringArray.get("Beejay"));

        assertEquals(1, myStringArray.get("Moh"));
    }

    @Test
    public void hasTwoElement_canInsertinIndexZero() {
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        assertEquals("Moh", myStringArray.get(0));
        assertEquals("Beejay", myStringArray.get(1));

        myStringArray.insert(0, "Jumoke");

        assertEquals(0, myStringArray.get("Jumoke"));
        assertEquals(1, myStringArray.get("Moh"));
        assertEquals(2, myStringArray.get("Beejay"));
    }

    @Test
    public void cantInsertElementsToListThatsMoreThanTheExistingSize() {
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> myStringArray.insert(3, "Jumoke"));
    }

    @Test
    public void checkElementContainInAList() {
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        assertTrue(myStringArray.contain("Beejay"));
    }

    @Test
    public void checkElementContainInAListIgnoreCase() {
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        myStringArray.add("Blessing");
        assertTrue(myStringArray.contain("bleSSING"));
    }

    @Test
    public void checkElementInAList_returnFalse() {
        assertTrue(myStringArray.isEmpty());
        myStringArray.add("Moh");
        myStringArray.add("Beejay");
        myStringArray.add("Blessing");
        assertFalse(myStringArray.contain("Jumoke"));
    }

}
