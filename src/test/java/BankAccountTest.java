import org.example.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    public void setUp(){
        bankAccount = new BankAccount("Sujan", "Sriram", LocalDate.of(1998,9,9), 9091998, "Savings", 2000);
    }

    @Test
    public void canGetFirstName(){
        String actual = bankAccount.getFirstName();
        String expected = "Sujan";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void canGetLastName(){
        String actual = bankAccount.getLastName();
        String expected = "Sriram";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void canGetDOB(){
        LocalDate actual = bankAccount.getDateOfBirth();
        String expected = "1998-09-09";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void canGetAccountNumber(){
        int actual = bankAccount.getAccountNumber();
        int expected = 9091998;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void canGetAccountType(){
        String actual = bankAccount.getAccountType();
        String expected = "Savings";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void canSetBalance(){
        bankAccount.setBalance(1000000);
        double actual = bankAccount.getBalance();
        double expected = 1000000;
        assertThat(actual).isEqualTo(expected);
    }



    @Test
    public void canDeposit(){
        bankAccount.deposit(50000);
        double actual = bankAccount.getBalance();
        double expected = 50000;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void canWithdraw(){
        bankAccount.withdrawal(1000);
        double actual = bankAccount.getBalance();
        double expected = -1000;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void canPayInterest(){
        bankAccount.setBalance(10000);
        bankAccount.setAccountType("Savings");
        bankAccount.interest(3);
        double actual = bankAccount.getBalance();
        double expected = 10300;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void doesNotPayInterest(){
        bankAccount.setBalance(10000);
        bankAccount.setAccountType("Current");
        bankAccount.interest(3);
        double actual = bankAccount.getBalance();
        double expected = 10000;
        assertThat(actual).isEqualTo(expected);
    }
}
