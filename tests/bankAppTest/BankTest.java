package bankAppTest;

import bankApp.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank bank;
    private Account account;

    @BeforeEach
    public void initializeBank() throws InvalidPinException {
        bank = new Bank("Uba");
        account = bank.registerCustomer("Dayo Akinyemi", "2090171769", "1234");
    }


//    @Test
//    public void BankCanRegisterCustomer(){
//        Account accountTwo = bank.registerCustomer("Dayo Akinyemi", "2090171769", "1234");
//        Account new_acc = new Account("Dayo Akinyemi", "1234", 2090171769);
//        assertEquals(new_acc, accountTwo);
//    }

    @Test
    public void BankCanFindAccount() throws InvalidPinException {
        assertEquals(account, bank.findAccount(2090171769));
    }

    @Test
    public void BankThrowsIllegalArguementIfAccountNotInList() {
        assertThrows(IllegalArgumentException.class, ()->bank.findAccount(2090171763));
    }

    @Test
    public void BankCanDepositIntoAccount() throws InvalidAmountException, InvalidPinException {
        bank.deposit(2090171769, 5_000);
        assertEquals(5_000, account.checkBalance());
    }

    @Test
    public void BankThrowsIllegalArguementIfAccountNotInListToDeposit() {
        assertThrows(IllegalArgumentException.class, ()->bank.deposit(2090171459, 5_000));
    }

    @Test
    public void BankCanWithdrawMoneyFromAccount() throws InvalidPinException, InvalidAmountException, InsufficientFundsException {
        bank.deposit(2090171769, 5_000);
        bank.withdraw(2090171769, 2_000, "1234");
        assertEquals(3_000, account.checkBalance());
    }

    @Test
    public void BankCantWithdrawMoneyIfPinIsWrong() throws InvalidPinException, InvalidAmountException, InsufficientFundsException {
        bank.deposit(2090171769, 5_000);
        assertThrows(InvalidPinException.class, ()->bank.withdraw(2090171769, 2_000, "129334"));
    }

    @Test
    public void BankCantWithdrawIfWithdrawAmountGreaterThanBalance() throws InvalidPinException, InvalidAmountException {
        bank.deposit(2090171769, 5_000);
        assertThrows(InsufficientFundsException.class, ()->bank.withdraw(2090171769, 10_000, "1234"));
    }

    @Test
    public void BankCantWithdrawIfAccountDoesntExist() {
        assertThrows(IllegalArgumentException.class, ()->bank.withdraw(2090172329, 10_000, "1234"));
    }

    @Test
    public void BankCanTransferToAnotherAccount() throws InvalidPinException, InsufficientFundsException, InvalidAmountException {
        Account account2 = bank.registerCustomer("Moh Baba", "2090676790", "1827");
        assertEquals(0, account2.checkBalance());

        bank.deposit(2090171769, 18_000);
        assertEquals(18_000, account.checkBalance());

        bank.transfer(2090171769, 2090676790, 5_000, "1234");
        assertEquals(13_000, account.checkBalance());

        assertEquals(5_000, account2.checkBalance());
    }

    @Test
    public void BankCantTransferToAnotherAccountThatDoesNotExist() throws InvalidAmountException {
        bank.deposit(2090171769, 18_000);
        assertEquals(18_000, account.checkBalance());

        assertThrows(IllegalArgumentException.class, ()-> bank.transfer(2090171769, 2090676790, 5_000, "1234"));
        assertEquals(18_000, account.checkBalance());
    }

    @Test
    public void BankCanCheckBalance() throws InvalidAmountException, InvalidPinException {
        bank.deposit(2090171769, 18_000);
        assertEquals(18_000, bank.checkBalance(2090171769, "1234"));
    }

    @Test
    public void balanceCantCheckBalanceIfPinIsWrong() throws InvalidAmountException, InvalidPinException {
        bank.deposit(2090171769, 18_000);
        assertThrows(InvalidPinException.class, ()->bank.checkBalance(2090171769, "123544"));
    }

    @Test
    public void BankCanRemoveAccount() throws InvalidPinException {
        bank.removeAccount(2090171769, "1234");
        assertEquals(0, bank.numberOfAccounts());
    }

    @Test
    public void BankCanRemoveAccountAfterAdding() throws InvalidPinException {
        Account account2 = bank.registerCustomer("Moh Baba", "2090676790", "1827");
        assertEquals(2, bank.numberOfAccounts());

        bank.removeAccount(2090676790, "1827");
        assertEquals(1, bank.numberOfAccounts());
    }

    @Test
    public void BankCantRemoveAccountIfPinIsWrong() {
        assertThrows(InvalidPinException.class, ()->bank.removeAccount(2090171769, "123864"));
    }
}
