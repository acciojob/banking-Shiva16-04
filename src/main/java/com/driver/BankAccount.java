package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;
    private String accountNumber;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        accountNumber= uniqueNumberGeneration(digits, sum,"", true);
        if(accountNumber!=null)return accountNumber;
        else throw new AccountNumberCannotbeGeneratedException("Account Number can not be generated");
    }

    public void deposit(double amount) {
        //add amount to balance
        setBalance(getBalance()+amount);
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(getBalance()-amount<getMinBalance()){
            throw new InsufficientBalanceException("Insufficient Balance");
        }else{
            setBalance(getBalance()-amount);
        }
    }

    private static String uniqueNumberGeneration(int digits, int sum, String accountNumber, boolean firstdigit){
        if(digits==0){
            if(sum==0) return accountNumber;
            else return null;
        }
         int startDigit=firstdigit?1:0;
        for(int i=startDigit; i<=9; i++){
            String number=uniqueNumberGeneration(digits-1, sum-i, accountNumber+i, false);
            if(number!=null)return number;
        }
        return null;
    }

}
