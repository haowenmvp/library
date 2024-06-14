package com.example.demo.controller;


import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Api(value = "Book Management System", tags = {"Book Management"})
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    @ApiOperation(value = "View a list of available books", response = List.class)
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a book by Id", response = Book.class)
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a book")
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a book by Id")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
