package com.driver;

public class MaximumWithdrawLimitExceededException extends Exception{
    MaximumWithdrawLimitExceededException(String message){
        super(message);
    }
}
