package chapter15.streams;

import java.io.IOException;
import java.io.PrintStream;

public class Example {
    public static void main(String[] args) {
        String fileLocation = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15\\streams\\sample.txt";
        try(PrintStream printStream = new PrintStream(fileLocation)){
            printStream.println("Hello World");  //dis writes to a file
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
