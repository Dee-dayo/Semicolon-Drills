package diary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    private Diary diary;
    @BeforeEach
    public void initializeDiary(){
        diary = new Diary("userName", "correctPassword");
    }

    @Test
    public void diaryIsLocked(){
        assertTrue(diary.isLocked());
    }
    @Test
    public void diaryIsLocked_canBeUnlockedWithCorrectPassword(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("correctPassword");
        assertFalse(diary.isLocked());
    }
    @Test
    public void diaryIsLocked_cantBeUnlockedWithWrongPassword(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("incorrectPassword");
        assertTrue(diary.isLocked());
    }
    @Test
    public void diaryIsUnlocked_canLockDiary(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("correctPassword");
        assertFalse(diary.isLocked());

        diary.lockDiary();
        assertTrue(diary.isLocked());
    }
    @Test
    public void diaryCanCreateEntry(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("correctPassword");
        assertFalse(diary.isLocked());

        diary.createEntry("1st Day in Semicolon", "I met chibuzo");
        assertEquals(1, diary.noOfEntries());
    }
    @Test
    public void entryCantBeCreatedIfDiaryIsLocked(){
        assertTrue(diary.isLocked());
        diary.createEntry("1st Day in Semicolon", "I met chibuzo");
        assertEquals(0, diary.noOfEntries());
    }
    @Test
    public void entryIsCreated_CanFindEntryWithIdNo(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("correctPassword");
        assertFalse(diary.isLocked());

        diary.createEntry("1st Day in Semicolon", "I met chibuzo");
        assertEquals(1, diary.noOfEntries());

        Entry actualEntry = diary.findEntrybyIdNo(1);
        assertEquals("1st Day in Semicolon", actualEntry.getTitle());
        assertEquals("I met chibuzo", actualEntry.getBody());
    }
    @Test
    public void entryIsCreated_cantFindEntryWithIncorrectId_throwException(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("correctPassword");
        assertFalse(diary.isLocked());

        diary.createEntry("1st Day in Semicolon", "I met chibuzo");
        assertEquals(1, diary.noOfEntries());

        assertThrows(InvalidIdNoException.class, ()->diary.findEntrybyIdNo(2));
    }
    @Test
    public void entryIsCreated_canDeleteCreatedEntry(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("correctPassword");
        assertFalse(diary.isLocked());

        diary.createEntry("1st Day in Semicolon", "I met chibuzo");
        assertEquals(1, diary.noOfEntries());

        diary.deleteEntry(1);
        assertEquals(0, diary.noOfEntries());
    }
    @Test
    public void twoEntryIsCreated_canDeleteCreatedEntryByIdNo(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("correctPassword");
        assertFalse(diary.isLocked());

        diary.createEntry("1st Day in Semicolon", "I met chibuzo");
        diary.createEntry("2nd Day in Semicolon", "I met my fellow cohort mates");
        assertEquals(2, diary.noOfEntries());

        Entry entry = diary.findEntrybyIdNo(1);
        assertEquals("1st Day in Semicolon", entry.getTitle());

        Entry secondEntry = diary.findEntrybyIdNo(2);
        assertEquals("2nd Day in Semicolon", secondEntry.getTitle());

        diary.deleteEntry(1);
        assertEquals(1, diary.noOfEntries());

        diary.deleteEntry(2);
        assertEquals(0, diary.noOfEntries());

        assertThrows(InvalidIdNoException.class, ()->diary.deleteEntry(1));
    }

    @Test
    public void entryIsCreated_canUpdateEntry(){
        assertTrue(diary.isLocked());
        diary.unLockDiary("correctPassword");
        assertFalse(diary.isLocked());

        diary.createEntry("1st Day in Semicolon", "I met chibuzo");
        Entry entry = diary.findEntrybyIdNo(1);
        assertEquals("1st Day in Semicolon", entry.getTitle());
        assertEquals("I met chibuzo", entry.getBody());

        int idNo = entry.getIdNo();
        diary.updateEntry(idNo, "Onboarding Semicolon", "I joined 40 new cohort members");

        assertEquals("Onboarding Semicolon", entry.getTitle());
        assertEquals("I joined 40 new cohort members", entry.getBody());
    }
}