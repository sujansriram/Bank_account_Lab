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
        assertThat(bankAccount.getFirstName()).isEqualTo("Sujan");
    }

    @Test
    public void canGetLastName(){
        assertThat(bankAccount.getLastName()).isEqualTo("Sriram");
    }

    @Test
    public void canGetDOB(){
        assertThat(bankAccount.getDateOfBirth()).isEqualTo("1998-09-09");
    }

    @Test
    public void canGetAccountNumber(){
        assertThat(bankAccount.getAccountNumber()).isEqualTo(9091998);
    }

    @Test
    public void canGetAccountType(){
        assertThat(bankAccount.getAccountType()).isEqualTo("Savings");
    }

    @Test
    public void canSetBalance(){
        bankAccount.setBalance(1000000);
        assertThat(bankAccount.getBalance()).isEqualTo(1000000);
    }



    @Test
    public void canDeposit(){
        bankAccount.deposit(50000);
        assertThat(bankAccount.getBalance()).isEqualTo(50000);
    }
    @Test
    public void canWithdraw(){
        bankAccount.withdrawal(1000);
        assertThat(bankAccount.getBalance()).isEqualTo(-1000);
    }
    @Test
    public void canPayInterest(){
        bankAccount.setBalance(10000);
        bankAccount.setAccountType("Savings");
        bankAccount.interest(3);
        assertThat(bankAccount.getBalance()).isEqualTo(10300);
    }
    @Test
    public void doesNotPayInterest(){
        bankAccount.setBalance(10000);
        bankAccount.setAccountType("Current");
        bankAccount.interest(3);
        assertThat(bankAccount.getBalance()).isEqualTo(10000);
    }
}
