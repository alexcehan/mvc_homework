package com.example.demo.exception;

public class PeakNotFoundException extends RuntimeException{
    public PeakNotFoundException(String message) {
        super(message);
    }
}
