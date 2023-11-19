package com.huseyinyetisir.BookstoreBE.controller;

import com.huseyinyetisir.BookstoreBE.entity.Book;
import com.huseyinyetisir.BookstoreBE.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;

    private String userEmail = "testuser@email.com";

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(@RequestHeader(value = "Authorization") String token, @RequestParam Long bookId) {

        return bookService.checkoutBookByUser(userEmail, bookId);
    }

    @GetMapping("/secure/checkout")
    public Book checkoutBook(@RequestHeader(value = "Authorization") String token, @RequestParam Long bookId)
            throws Exception {
        return bookService.checkoutBook(userEmail, bookId);

    }

    @GetMapping("/secure/currentloans/count")
    public int currentloansCount(@RequestHeader(value = "Authorization") String token) {
        return bookService.currentLoansCount(userEmail);
    }

}
