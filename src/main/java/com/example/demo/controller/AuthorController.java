package com.example.demo.controller;


import com.example.demo.domain.Author;
import com.example.demo.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@Api(value = "Author Management System", tags = {"Author Management"})
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    @ApiOperation(value = "View a list of available authors", response = List.class)
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get an author by Id", response = Author.class)
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a new author")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete an author by Id")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}
