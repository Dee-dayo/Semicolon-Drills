package diary;

import javax.swing.*;
import java.util.Scanner;

public class MainApplication {
    private static final Diaries diaries = new Diaries();
    private static final Diary diary = new Diary("Dee's Diary", "1234");

    public static void main(String[] args) {
        mainApp();
    }
    public static void mainApp(){
        displayPage();
    }

    private static void displayPage() {
        print("""
                \nWelcome to Dee's Diary App
                1-> Create Diary
                2-> Find Diary
                3-> Unlock Diary
                4-> Add Entry
                5-> Lock Diary
                6-> Delete Entry
                7-> Find Entry
                8-> Update Entry
                9-> Exit App
                """);
        String userInput = input("");

        switch (userInput.charAt(0)){
            case '1' -> createDiary();
            case '2' -> findDiary();
            case '3' -> unlockDiary();
            case '4' -> addEntry();
            case '5' -> lockDiary();
            case '6' -> deleteEntry();
            case '7' -> findEntry();
            case '8' -> updateEntry();
            case '9' -> exit();
        }
    }

    private static void updateEntry() {
        print("UPDATE AN ENTRY IN DIARY");
        String idNo = input("Enter Entry ID no");
        String title = input("Enter new title for entry");
        String body = input("Enter new body for entry");
        try {
            diary.updateEntry(Integer.parseInt(idNo), title, body);
            print("<<<Entry updated successfully>>>");
        } catch (Exception e){
            print(e.getMessage());
        } finally {
            displayPage();
        }
    }

    private static void findEntry() {
        print("FIND AN ENTRY IN DIARY");
        String idNo = input("Enter entry ID no to search");
        try {
            Entry entry = diary.findEntrybyIdNo(Integer.parseInt(idNo));
            print(entry.getTitle() + " " + entry.getBody());
        } catch (Exception e){
            print(e.getMessage());
        } finally {
            displayPage();
        }
    }

    private static void deleteEntry() {
        print("DELETE AN ENTRY IN DIARY");
        String idNo = input("Enter entry ID no");
        try {
            diary.deleteEntry(Integer.parseInt(idNo));
            print("<<<Entry deleted Successfully>>>");
        } catch (Exception e){
            print(e.getMessage());
        } finally {
            displayPage();
        }
    }

    private static void lockDiary() {
        diary.lockDiary();
        print("<<<Diary Locked Successfully>>>");
        displayPage();
    }

    private static void addEntry() {
        print("ADD ENTRY TO DIARY");
        String title = input("Enter your entry title");
        String body = input("Enter your entry body");
        try {
            diary.createEntry(title, body);
            print("<<<Entry Created Successfully>>>");
        } catch (Exception e){
            print(e.getMessage());
        } finally {
            displayPage();
        }
    }

    private static void unlockDiary() {
        String option = input("Have you created a diary? If yes, press 1, if no, press 2");
        if (option.equals("1")){
            String password = input("Enter you diary password");
            try {
                diary.unLockDiary(password);
                print("<<<Diary Unlocked Successfully>>>");
            } catch (Exception e){
                print(e.getMessage());
            }finally {
                displayPage();
            }
        } else{
            createDiary();
        }
    }

    private static void findDiary() {
        print("BOOKSHELF DIARIES");
        String diaryName = input("Enter diary username you are looking for");
        try {
            Diary diary1 = diaries.findByUsername(diaryName);
            print("Welcome " + diary1.getUsername());
        } catch (Exception e){
            print(e.getMessage());
        }finally {
            displayPage();
        }
    }

    private static void createDiary() {
        print("BOOKSHELF DIARIES");
        String diaryName = input("Enter your desired diary name");
        String diaryPassword = input("Enter your desired diary password");
        try {
            diaries.add(diaryName, diaryPassword);
            print("<<<" + diaryName + " Created Successfully>>>");
        } catch (Exception message){
            print(message.getMessage());
        } finally {
            displayPage();
        }
    }

    private static void exit(){
        print("Thanks for using the Diary app");
        System.exit(0);
    }
    private static String input(String input){
//        print(input);
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
        return JOptionPane.showInputDialog(null, input);
    }
    private static void print(String message) {
//        System.out.println(message);
        JOptionPane.showMessageDialog(null,message);
    }

}
