package com.example.springmvc01.exception;

import org.springframework.stereotype.Controller;

public class BookNotFoundException extends Exception
{
    public BookNotFoundException(String message) {
        super(message);
    }
}
