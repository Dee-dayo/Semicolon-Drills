package chapter15drills;

import chapter15.json.serialization.JsonSerializer;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Drills {

    public static List<Transaction> transactionBetweenPeriod(LocalDate start, LocalDate stop) {
         Path path = Paths.get("C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15drills\\transacts.json");
        try {
            String files = Files.readString(path);
            Transaction[] transactions = JsonSerializer.deserializeTransaction(files);

            return Arrays.stream(transactions).filter((transaction) -> transaction.getDateCreated().compareTo(start) >= 0 && transaction.getDateCreated().compareTo(stop) <= 0).toList();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    public static List<Transaction> dailyTransaction(LocalDate date){
        Path path = Paths.get("C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15drills\\transacts.json");
        try {
            String files = Files.readString(path);
            Transaction[] transactions = JsonSerializer.deserializeTransaction(files);
            return Arrays.stream(transactions).filter((transaction)-> transaction.getDateCreated().equals(date)).toList();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

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

    public static BigDecimal averageTransactionAmountBetweenPeriod(LocalDate start, LocalDate stop) throws IOException {
        Path path = Paths.get("C:\\Users\\DELL\\IdeaProjects\\Semicolon\\src\\chapter15drills\\transacts.json");
        String files = Files.readString(path);
        Transaction[] transactions = JsonSerializer.deserializeTransaction(files);
        List<Transaction> transacts = Arrays.stream(transactions).filter((transaction) -> transaction.getDateCreated().compareTo(start) >= 0 && transaction.getDateCreated().compareTo(stop) <= 0).toList();
        var value = transacts.stream().map(Transaction::getAmount).mapToDouble(BigDecimal::doubleValue).average();
       return BigDecimal.valueOf(value.getAsDouble());
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
