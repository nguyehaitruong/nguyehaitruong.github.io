package com.example.springmvc01.controller;

import com.example.springmvc01.entity.Book;
import com.example.springmvc01.entity.BookBorrowed;
import com.example.springmvc01.entity.Reader;
import com.example.springmvc01.exception.BookNotFoundException;
import com.example.springmvc01.model.request.BorrowBookCreationRequest;
import com.example.springmvc01.service.BookService;
import com.example.springmvc01.service.BorrowBookService;
import com.example.springmvc01.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subject")
@AllArgsConstructor
public class SubjectController {

    private final BookService bookService;
    private final ReaderService readerService;
    private final BorrowBookService borrowBookService;

    @GetMapping("/initialization")
    public String borrowBookInit(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("dsSach", books);

        List<Reader> readers = readerService.getAll();
        model.addAttribute("dsBanDoc", readers);
        model.addAttribute("luotMuonSach", new BorrowBookCreationRequest());
        return "subject-creation";
    }

    @PostMapping
    public String createBorrowBook(@ModelAttribute("luotMuonSach") BorrowBookCreationRequest request, Model model) throws BookNotFoundException {
        List<BookBorrowed> borrowBooks =  borrowBookService.createBorrowBook(request);
        model.addAttribute("dsMuon", borrowBooks);
        return "subject";
    }
    @GetMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model) throws BookNotFoundException {
        List<Book> books = bookService.deleteBook(id);
        model.addAttribute("dsSach", books);
        return "subject";
    }


    @GetMapping
    public String getBorrowBooks(Model model) {
        // gọi xuống service để lấy các lượt mượn
//        model.addAttribute("dsMuon", borrowBooks);
        return "subject";
    }


}
