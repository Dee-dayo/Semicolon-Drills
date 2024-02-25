package diary;

import java.util.ArrayList;

public class Diary {
    private String userName;
    private final String password;
    private final ArrayList<Entry> entries = new ArrayList<>();
    private int entryId = 1;
    private boolean isLocked = true;

    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void createEntry(String entryTitle, String entryBody) {
        if (!isLocked()) {
            Entry entry = new Entry(generateEntryId(), entryTitle, entryBody);
            entries.add(entry);
        }
    }

    private int generateEntryId(){
        entryId += entries.size();
        return entryId;
    }

    public int noOfEntries() {
        return entries.size();
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unLockDiary(String password) {
        if (isCorrectPassword(password)) isLocked = false;
    }

    public boolean isCorrectPassword(String password){
        return this.password.equals(password);
    }

    public void lockDiary() {
        isLocked = true;
    }

    public Entry findEntrybyIdNo(int idNo) {
        for (Entry entry: entries){
            if (entry.getIdNo() == idNo) return entry;
        }
        throw new InvalidIdNoException("EntryId not found");
    }

    public void deleteEntry(int idNo) {
        Entry entry = findEntrybyIdNo(idNo);
        entries.remove(entry);
    }

    public void updateEntry(int idNo, String entryTitle, String entryBody) {
        Entry entry = findEntrybyIdNo(idNo);
        entry.setTitle(entryTitle);
        entry.setBody(entryBody);
    }

    public String getUsername(){
        return userName;
    }
}
