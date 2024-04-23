package regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {

    @Test
    public void testValidatePhoneNumber(){
        String phoneNumber = "";
        boolean expected = DataValidator.isPhoneNumberValid(phoneNumber);
        assertFalse(expected);
    }

    @Test
    public void testValidateCorrectNumber(){
        String number = "08172581637";
        boolean expected = DataValidator.isPhoneNumberValid(number);
        assertTrue(expected);
    }

    @Test
    public void testValidateWith234(){
        String number = "+2348172581637";
        boolean expected = DataValidator.isPhoneNumberValid(number);
        assertTrue(expected);
    }

    @Test
    public void testValidateWithInvalidNumber(){
        String number = "048ad839283";
        boolean expected = DataValidator.isPhoneNumberValid(number);
        assertFalse(expected);
    }

    @Test
    public void testValidateWithPlus234(){
        String number = "2348172581637";
        boolean expected = DataValidator.isPhoneNumberValid(number);
        assertTrue(expected);
    }

    @Test
    public void testValidateWith0711(){
        String number = "07116273847";
        boolean expected = DataValidator.isPhoneNumberValid(number);
        assertFalse(expected);
    }

    @Test
    public void testValidateWithDash(){
        String number = "+234-8172638434";
        boolean expected = DataValidator.isPhoneNumberValid(number);
        assertTrue(expected);
    }

    @Test
    public void testValidateWithSpace(){
        String number = "070 162 738 47";
        boolean expected = DataValidator.isPhoneNumberValid(number);
        assertTrue(expected);
    }

    @Test
    public void testValidateEmailAddress(){
        String email = "darhyor2050@gmail.com";
        boolean expected = DataValidator.isEmailValid(email);
        assertTrue(expected);
    }

    @Test
    public void testInvalidEmailAddress(){
        String email = "";
        boolean expected = DataValidator.isEmailValid(email);
        assertFalse(expected);
    }
}