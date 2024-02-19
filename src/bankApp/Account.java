package bankApp;

import java.util.InvalidPropertiesFormatException;

public class Account {
    private String accountName;
    private int accountBalance;
    private String accountPin;
    private int accountNumber;

    public Account(String accountName, String accountPin, int accountNumber) throws InvalidPinException {
        this.accountName = accountName;
        if (accountPin.length() == 4) {
            this.accountPin = accountPin;
        } else throw new InvalidPinException();
        this.accountNumber = accountNumber;
        accountBalance = 0;
    }

    public Account(String accountName, String accountNumber, String accountPin) throws InvalidPinException {
        this.accountName = accountName;
        this.accountNumber = Integer.parseInt(accountNumber);
        if (accountPin.length() == 4) {
            this.accountPin = accountPin;
        } else throw new InvalidPinException();
        accountBalance = 0;
    }

    public void deposit(int amount) throws InvalidAmountException {
        if (amount < 0) throw new InvalidAmountException();
        else accountBalance += amount;
    }

    public int checkBalance(String accountPin) throws InvalidPinException {
        if (this.accountPin.equals(accountPin)) return accountBalance;
        else throw new InvalidPinException();
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > 0) {
            if (amount < accountBalance) accountBalance -= amount;
            else throw new InsufficientFundsException();
        }
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public int checkBalance(){
        return accountBalance;
    }

    public boolean checkPinValidity(String accountPin) throws InvalidPinException {
        if (this.accountPin.equals(accountPin) && accountPin.length() == 4) return true;
        else throw new InvalidPinException();
    }
}
