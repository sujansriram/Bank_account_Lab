package org.example;

import java.time.LocalDate;

public class BankAccount {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance;
    public String accountType;
    private int overdraft;

    public BankAccount(String inputFName, String inputLName, LocalDate inputDOB, int inputAccNumber, String inputAccType, int inputOverDraft){
        this.firstName = inputFName;
        this.lastName = inputLName;
        this.dateOfBirth = inputDOB;
        this.accountNumber = inputAccNumber;
        this.balance = 0;
        this.accountType = inputAccType;
        this.overdraft = inputOverDraft;
    }

//    methods

    public void deposit( double depositAmount){
        this.balance += depositAmount;
    }

    public void withdrawal( double withdrawalAmount){
        if (withdrawalAmount < this.balance + overdraft) {
            this.balance -= withdrawalAmount;
        }
    }
    
    public void interest( double interestRateInPercentage){
        if (this.accountType.equals("Savings")){
            this.balance *= (1 + (interestRateInPercentage / 100));
        }
    }

//        getters & setters
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }
    public double getBalance(){
        return this.balance;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String newAccType){
        this.accountType = newAccType;
    }
}
