package chapter15.streams;

import java.io.*;

public class Example4 {
    public static void main(String[] args) {
        String fileLocation = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15\\streams\\sample4.txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileLocation, true)){ //d true is to add more into d file, nd nt to overwrite wts dere
            fileOutputStream.write("Welcome to dayo's world".getBytes());  //writes into a created file
        } catch (IOException exception){
            System.err.println(exception.getMessage());
        }
    }
}
