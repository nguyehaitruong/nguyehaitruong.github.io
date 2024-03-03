package com.example.jobseeker.exception;

public class OTPNotMatchedException extends Exception {
    public OTPNotMatchedException(String message) {
        super(message);
    }
}
