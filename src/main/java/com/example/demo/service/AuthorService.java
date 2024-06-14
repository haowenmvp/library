package com.example.demo.service;

import com.example.demo.domain.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author findById(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public void deleteById(Long id){
        authorRepository.deleteById(id);
    }
}
