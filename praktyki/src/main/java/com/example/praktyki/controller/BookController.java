package com.example.praktyki.controller;

import com.example.praktyki.dto.BookDto;
import com.example.praktyki.entity.Book;
import com.example.praktyki.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private final BookService bookService;

//    @Autowired
//    BookService bookService;

    @GetMapping("/book2")
    public BookDto getBook(){
        return bookService.getBook();
    }

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping
    public void insert(@RequestBody Book book) {
        this.bookService.save(book);
    }

    @PutMapping
    public void update(@RequestBody Book book) {
        this.bookService.save(book);
    }

}