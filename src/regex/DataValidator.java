package regex;

public class DataValidator {
    public static boolean isPhoneNumberValid(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll(" ", "");
        String regex = "((234|\\+234)-?|0)?(70|[8-9][0-1])\\d{8}";
        /*
        d replace all will remove all spaces in d number
        d first 234 picks that it starts from 234
        d second +234 says it starts from +234
        d - says it can have - after d 234   optionally though
        d | 0 means if it doesnt do d 234, it can start with 0
        d ? after d zero means d zero sef is optional

        d 70 means after 234, it can start with 70 or can start with either 8 or 9 then with either 0 or 9
        d //d means it will have 8 digits after all
         */
        return phoneNumber.matches(regex);
    }

    public static boolean isEmailValid(String email) {
        String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        return email.matches(regex);
    }
}
