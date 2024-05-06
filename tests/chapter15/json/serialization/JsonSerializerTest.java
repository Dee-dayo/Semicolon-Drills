package chapter15.json.serialization;

import org.junit.jupiter.api.Test;


import static chapter15.json.serialization.Sex.FEMALE;
import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerTest {

    @Test
    public void testJsonSerializer() {
        Person person = new Person();
        person.setName("Aramide");
        person.setDateOfBirth("2024-3-03");
        person.setSex(FEMALE);
        person.setPhoneNumber("09203938394");

        String json = JsonSerializer.serialize(person);
        String expected = "{\"name\":\"Aramide\",\"dateOfBirth\":\"2024-3-03\",\"phoneNumber\":\"09203938394\",\"sex\":\"FEMALE\"}";
        assertEquals(expected, json);
    }

    @Test
    public void testJsonDeserialize(){
        Person person = new Person();
        person.setName("Aramide");
        person.setDateOfBirth("2024-3-03");
        person.setSex(FEMALE);
        person.setPhoneNumber("09203938394");
        String json = JsonSerializer.serialize(person);


        Person newPerson = JsonSerializer.deserialize(json);
        assertEquals("Aramide", newPerson.getName());
        assertEquals(person.getDateOfBirth(), newPerson.getDateOfBirth());
        assertEquals("09203938394", newPerson.getPhoneNumber());
        assertEquals(FEMALE, newPerson.getSex());
    }

}