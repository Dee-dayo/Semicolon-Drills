package chapter15.json.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer {

    public static String serialize(Person person) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(person);
            return json;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Person deserialize(String json) {
        try{
             ObjectMapper mapper = new ObjectMapper();
            Person person = mapper.readValue(json, Person.class);
            return person;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
