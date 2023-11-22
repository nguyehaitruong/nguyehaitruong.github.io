package com.example.springmvc01.controller;

import com.example.springmvc01.entity.Book;
import com.example.springmvc01.exception.BookNotFoundException;
import com.example.springmvc01.model.request.BookCreationRequest;
import com.example.springmvc01.model.request.BookUpdateRequest;
import com.example.springmvc01.model.response.BookDetailResponse;
import com.example.springmvc01.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


// DTO --> data transfer objects
// view - model --> vm

@Controller
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/students")
    public String home(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("dsSach", books);
        return "students";
    }

    @GetMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model) throws BookNotFoundException {
        List<Book> books = bookService.deleteBook(id);
        model.addAttribute("dsSach", books);
        return "students";
    }

    @GetMapping("/create-student")
    public String forwardToBookCreation(Model model) {
        model.addAttribute("sachMuonThemMoi", new BookCreationRequest());
        return "student-creation";
    }

    @PostMapping("/create-student")
    public String createBook(@ModelAttribute("sachMuonThemMoi") @Valid BookCreationRequest book, Errors errors) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "student-creation";
        }
        List<Book> books = bookService.createBook(book);
//            model.addAttribute("dsSach", books);
        return "redirect:/students";

    }

    @GetMapping("/update-book/{book-id}")
    public String forwardToBookUpdate(Model model, @PathVariable("book-id") int id) throws BookNotFoundException {
        BookDetailResponse book = bookService.findById(id);
        model.addAttribute("sachMuonCapNhat", book);
        return "student-update";
    }

    @PostMapping("/update-book")
    public String updateBook(@ModelAttribute("sachMuonCapNhat") @Valid BookUpdateRequest book, Errors errors) throws BookNotFoundException {
        if (null != errors && errors.getErrorCount() > 0) {
            return "student-update";
        }
        List<Book> books = bookService.updateBook(book);
//        model.addAttribute("dsSach", books);
        return "redirect:/students";
    }


}
