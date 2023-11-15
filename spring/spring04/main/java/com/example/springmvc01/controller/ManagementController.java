package com.example.springmvc01.controller;

import com.example.springmvc01.entity.Book;
import com.example.springmvc01.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


// DTO --> data transfer objects
// view - model --> vm

@Controller
@AllArgsConstructor
public class ManagementController {

    private final BookService bookService;

    @GetMapping("/management")
    public String home(Model model) {

        return "management.html";
    }



}
