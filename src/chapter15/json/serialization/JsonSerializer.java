package chapter15.json.serialization;

import chapter15drills.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer {

    public static String serialize(Person person) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public static String serialize(Transaction transaction) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(transaction);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Person deserialize(String json) {
        try{
             ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Person.class);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }


    public static Transaction[] deserializeTransaction(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Transaction[].class);
    }


}
