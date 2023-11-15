package com.example.springmvc01.controller;

import com.example.springmvc01.entity.Book;
import com.example.springmvc01.model.request.BookCreationRequest;
import com.example.springmvc01.model.request.BookUpdateRequest;
import com.example.springmvc01.model.response.BookDetailResponse;
import com.example.springmvc01.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


// DTO --> data transfer objects
// view - model --> vm

@Controller
@AllArgsConstructor
public class ServiceController {

    private final BookService bookService;

    @GetMapping("/service")
    public String home(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("dsSach", books);
        return "service";
    }

//    @GetMapping("/delete-book/{id}")
//    public String deleteBook(@PathVariable("id") int id, Model model) {
//        bookService.deleteBook(id);
//        List<Book> books = bookService.getAll();
//        model.addAttribute("dsSach", books);
//        return "service";
//    }
//
//    @GetMapping("/create-book")
//    public String forwardToBookCreation(Model model) {
//        model.addAttribute("sachMuonThemMoi", new BookCreationRequest());
//        return "book-creation";
//    }
//
//    @PostMapping("/create-book")
//    public String createBook(@ModelAttribute("sachMuonThemMoi") BookCreationRequest book, Model model) {
//        bookService.createBook(book);
//        List<Book> books = bookService.getAll();
//        model.addAttribute("dsSach", books);
//        return "service";
//    }
//
//    @GetMapping("/update-book/{book-id}")
//    public String forwardToBookUpdate(Model model, @PathVariable("book-id") int id) {
//        BookDetailResponse book = bookService.findById(id);
//        model.addAttribute("sachMuonCapNhat", book);
//        return "book-update";
//    }
//
//    @PostMapping("/update-book")
//    public String updateBook(@ModelAttribute("sachMuonCapNhat") BookUpdateRequest book, Model model) {
//        bookService.updateBook(book);
//        List<Book> books = bookService.getAll();
//        model.addAttribute("dsSach", books);
//        return "service";
//    }
//

}
