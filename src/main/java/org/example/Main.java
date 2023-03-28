package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("Sujan", "Sriram", LocalDate.of(1998,9,9), 9091998, "Savings", 2000);
        System.out.println(bankAccount.getDateOfBirth());
    }
}