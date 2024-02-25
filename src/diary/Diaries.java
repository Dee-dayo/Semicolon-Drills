package diary;

import bankApp.InvalidPinException;

import java.util.ArrayList;

public class Diaries {
    private ArrayList<Diary> diaries = new ArrayList<>();

    public void add(String diaryUsername, String diaryPassword) {
        Diary diary = new Diary(diaryUsername, diaryPassword);
        diaries.add(diary);
    }

    public int noOfDiaries() {
        return diaries.size();
    }

    public Diary findByUsername(String diaryUsername) {
        for (Diary diary: diaries){
            if (diary.getUsername().equals(diaryUsername)) return diary;
        }
        throw new InvalidUsernameException("Username not found");
    }

    public void delete(String diaryUsername, String diaryPassword) {
        Diary diary = findByUsername(diaryUsername);
        if(diary.isCorrectPassword(diaryPassword)) diaries.remove(diary);
        else throw new InvalidPinException("Password not Correct");
    }
}
