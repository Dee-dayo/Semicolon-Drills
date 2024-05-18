package chapter15drills;

import chapter15.json.serialization.JsonSerializer;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Drills {

    public static BigDecimal totalTransactions(String location) throws IOException {
        Path path = Paths.get(location);
        String files = Files.readString(path);

        Transaction[] json = JsonSerializer.deserializeTransaction(files);

        BigDecimal total = new BigDecimal(0);

        for(Transaction transaction : json){
            total = total.add(transaction.getAmount());
        }

        return total;

    }


    public static int totalNumberOfDigits(String location) throws IOException {
        Path path = Paths.get(location);
        String files = Files.readString(path);
        char[] fileChars = files.toCharArray();

        int count = 0;

        for (int counter =0 ;counter < files.length() ;counter++){
                if(Character.isDigit(fileChars[counter]))count++;
        }
        return count;
    }

    public static int totalNumberOfSentence(String location) throws IOException {
        Path path = Paths.get(location);
        String files = Files.readString(path);
        char[] fileChars = files.toCharArray();

        int count = 0;

        for (int counter =0 ;counter < files.length() ;counter++){
            if(fileChars[counter] == '.')count++;
        }
        return count;
    }


}
