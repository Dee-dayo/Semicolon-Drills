package chapter15.streams;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Example3 {
    public static void main(String[] args) {
        String fileLocation = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15\\streams\\sample3.txt";

        try (InputStream inputStream = new FileInputStream(fileLocation);
             DataInputStream dataInputStream = new DataInputStream(inputStream)){

            byte[] fileData = dataInputStream.readAllBytes() ;   //this reads from a file
            System.out.println(new String(fileData));
        } catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }
}
