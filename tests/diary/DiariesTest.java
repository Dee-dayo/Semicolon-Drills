package diary;

import bankApp.InvalidPinException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiariesTest {
    private Diaries diaries;

    @BeforeEach
    public void setUp(){
        diaries = new Diaries();
    }

    @Test
    public void diaryCanBeAddedToDiaries(){
        diaries.add("username", "correctPassword");
        assertEquals(1, diaries.noOfDiaries());
    }
    @Test
    public void diariesCanBeFindByUsername(){
        diaries.add("username", "correctPassword");

        Diary foundDiary = diaries.findByUsername("username");
        assertEquals("username",foundDiary.getUsername());

        diaries.add("dee", "correctPassword");
        Diary foundDiary2 = diaries.findByUsername("dee");
        assertEquals("dee",foundDiary2.getUsername());
    }
    @Test
    public void diariesCantBeFoundIfUsernameIncorrectOrNonExist(){
        diaries.add("username", "correctPassword");

        assertThrows(InvalidUsernameException.class, ()->diaries.findByUsername("moh"));
    }
    @Test
    public void diariesCanDeleteDiary(){
        diaries.add("username", "correctPassword");
        assertEquals(1, diaries.noOfDiaries());

        diaries.delete("username", "correctPassword");
        assertEquals(0, diaries.noOfDiaries());
    }
    @Test
    public void diariesCantDeleteIfUsernameWrong(){
        diaries.add("username", "correctPassword");
        assertEquals(1, diaries.noOfDiaries());

        assertThrows(InvalidUsernameException.class, ()->diaries.delete("USERname", "correctPassword"));
    }
    @Test
    public void diariesCantDeleteIfPasswordWrong(){
        diaries.add("username", "correctPassword");
        assertEquals(1, diaries.noOfDiaries());

        assertThrows(InvalidPinException.class, ()->diaries.delete("username", "incorrectPassword"));
    }
}
