package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000)throw new InsufficientBalanceException("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int count[]=new int[26];
        int max=0;
        for(int i=0; i<getTradeLicenseId().length();i++){
            count[getTradeLicenseId().charAt(i)-'A']++;
            if(count[getTradeLicenseId().charAt(i)-'A']>max)max=getTradeLicenseId().charAt(i)-'A';
        }
        if(max>(getTradeLicenseId().length()+1)/2){
            throw new InvalidLicenseException("Valid License can not be generated");
        }
    }

}
