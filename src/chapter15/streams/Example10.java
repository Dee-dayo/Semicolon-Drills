package chapter15.streams;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example10 {
    public static void main(String[] args) {
        String location = "C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15\\streams\\sample.txt";
        Path path = Paths.get(location);

        //using java nio instead of java.io
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write("Hpppy birthday");
            writer.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
