package bankAppTest;

import bankApp.Account;
import bankApp.InsufficientFundsException;
import bankApp.InvalidAmountException;
import bankApp.InvalidPinException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void initializeAccount() throws InvalidPinException {
        account = new Account("Dayo", "1234", 2090171769);
    }

    @Test
    public void AccountCanDeposit() throws InvalidPinException, InvalidAmountException {
        account.deposit(1_000);
        assertEquals(1000, account.checkBalance("1234"));
    }

    @Test
    public void AccountCantBeCreatedIfPinIsLessOrGreaterThan4Letters(){
        AtomicReference<Account> account1 = null;
        assertThrows(InvalidPinException.class, ()-> account1.set(new Account("Dayo", "12345", 2090171769)));

        AtomicReference<Account> account2 = null;
        assertThrows(InvalidPinException.class, ()-> account2.set(new Account("Moh", "adc", 2093847283)));
    }

    @Test
    public void AccountCanDeposit_balanceThrowsExceptionIfPasswordWrong() throws InvalidAmountException {
        account.deposit(1_000);
        assertThrows(InvalidPinException.class, ()-> account.checkBalance("2638"));
    }

    @Test
    public void AccountCanDeposit_AccountCanWithdraw() throws InvalidPinException, InsufficientFundsException, InvalidAmountException {
        account.deposit(1_000);
        account.withdraw(500);
        assertEquals(500, account.checkBalance("1234"));
    }

    @Test
    public void AccountDeposit_AccountThrowsExceptionIfInsufficientFund() throws InvalidAmountException {
        account.deposit(1_000);
        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(5_000));
    }

    @Test
    public void AccountCantDepositNegativeNumbers() {
        assertThrows(InvalidAmountException.class, ()-> account.deposit(-10_000));
    }

    @Test
    public void AccountCantWithdrawWithZeroBalance() {
        assertThrows(InsufficientFundsException.class, ()-> account.withdraw(1_000));
    }
}
