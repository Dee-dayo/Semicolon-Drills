package chapter15.streams;

import java.io.FileReader;
import java.io.IOException;

public class example5 {
    public static void main(String[] args) {
        String fileLocation = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15\\streams\\sample.txt";
        char[] fileChars = new char[100];

        try (FileReader fileReader = new FileReader(fileLocation)){  //reads a file
            int length = fileReader.read(fileChars);

            for (int counter =0 ;counter < length ;counter++){
                System.out.print(fileChars[counter]);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
