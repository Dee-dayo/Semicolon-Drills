package chapter15.streams;

import java.io.*;
import java.util.stream.Collectors;

public class example7 {
    public static void main(String[] args) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);  //to read from terminal
             BufferedReader reader = new BufferedReader(inputStreamReader)){

            System.out.print("Enter your data: ");
            String data = reader.readLine();
            System.out.println("You entered: "+data);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
