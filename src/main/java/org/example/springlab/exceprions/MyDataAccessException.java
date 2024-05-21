package org.example.springlab.exceprions;

public class MyDataAccessException extends RuntimeException {

    public MyDataAccessException(String message) {
        super(message);
    }
}
