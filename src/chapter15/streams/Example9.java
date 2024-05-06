package chapter15.streams;

import java.io.*;

public class Example9 {
    public static void main(String[] args) {
        try (OutputStreamWriter writer = new OutputStreamWriter(System.out);  //writes out string to d terminal
                BufferedWriter bufferedWriter = new BufferedWriter(writer)){
            bufferedWriter.write("Hello World");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
