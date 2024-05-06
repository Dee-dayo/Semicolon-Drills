package chapter15.streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class example6 {
    public static void main(String[] args) {
        String fileLocation = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15\\streams\\sample.txt";
        try (FileWriter fileWriter = new FileWriter(fileLocation)){
            fileWriter.write("Hello World");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
