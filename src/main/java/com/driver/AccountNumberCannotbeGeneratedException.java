package com.driver;

public class AccountNumberCannotbeGeneratedException extends Exception {
    AccountNumberCannotbeGeneratedException(String message) {
        super(message);
    }
}
