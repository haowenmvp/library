package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Book One");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Book Two");

        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        // When
        List<Book> books = bookService.findAll();

        // Then
        assertNotNull(books);
        assertEquals(2, books.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        // Given
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("Test Book");

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        // When
        Book foundBook = bookService.findById(bookId);

        // Then
        assertNotNull(foundBook);
        assertEquals(bookId, foundBook.getId());
        assertEquals("Test Book", foundBook.getTitle());
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    public void testSave() {
        // Given
        Book book = new Book();
        book.setTitle("New Book");

        when(bookRepository.save(book)).thenReturn(book);

        // When
        Book savedBook = bookService.save(book);

        // Then
        assertNotNull(savedBook);
        assertEquals("New Book", savedBook.getTitle());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testDeleteById() {
        // Given
        Long bookId = 1L;

        // When
        bookService.deleteById(bookId);

        // Then
        verify(bookRepository, times(1)).deleteById(bookId);
    }
}
