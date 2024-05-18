package chapter16;

import chapter15.json.serialization.Sex;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

// @JsonInnclude(JsonInclude.Include.NON_NULL) dis make sure if anyone is null, it doesnt add to the json
public class Person {
    private String name;
    @JsonSerialize(using = LocalDateSerializer.class)  //dis converts a class to json files for u
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate dateOfBirth;  //if u anotate @jsonpropert("Dob") it changes the attribute name to dob
    private String phoneNumber;
    private Sex sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
