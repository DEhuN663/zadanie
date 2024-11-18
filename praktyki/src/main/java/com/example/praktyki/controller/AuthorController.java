package com.example.praktyki.controller;

import com.example.praktyki.entity.Author;
import com.example.praktyki.service.AuthorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        authorService.deleteById(id);
    }

    @PostMapping
    public void insert(@RequestBody Author author) {
        this.authorService.save(author);
    }

    @PutMapping
    public void update(@RequestBody Author author) {
        this.authorService.save(author);
    }

}