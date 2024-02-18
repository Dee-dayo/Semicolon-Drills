package bankApp;

import java.util.List;
import java.util.ArrayList;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public Account registerCustomer(String fullName, String accNo, String accPin) throws InvalidPinException {
        Account account = new Account(fullName, accNo, accPin);
        accounts.add(account);
        return account;
    }

    public Account findAccount(int accNo) {
        for (int index = 0; index < accounts.size(); index++) {
            Account account = accounts.get(index);
            if (account.getAccountNumber() == accNo) return account;
        }
         throw new IllegalArgumentException("Account not Found");
    }

    public void deposit(int accNo, int amount) throws InvalidAmountException {
        Account account = findAccount(accNo);
        if (account != null) account.deposit(amount);
        else throw new IllegalArgumentException("Account not Found");
    }


    public void withdraw(int accNo, int amount, String pinNo) throws InvalidPinException, InsufficientFundsException {
        Account account = findAccount(accNo);

        if (account != null) {
            int balance = account.checkBalance(pinNo);

            if (balance >= amount) account.withdraw(amount);
            else throw new InsufficientFundsException();
        }
        else throw new IllegalArgumentException("Account not Found");
    }

    public void transfer(int accNo, int receiverAccNo, int amount, String pinNo) throws InvalidPinException, InsufficientFundsException, InvalidAmountException {
        Account senderAccount = findAccount(accNo);
        Account receiverAccount = findAccount(receiverAccNo);

        int senderBalance = senderAccount.checkBalance(pinNo);

        if (senderAccount != null && senderBalance >0) {
            senderAccount.withdraw(amount);

            if (receiverAccount != null) receiverAccount.deposit(amount);
            else throw new IllegalArgumentException("Account not Found");
        }
    }

    public int checkBalance(int accNo, String pinNo) {
        Account account = f
    }
}
