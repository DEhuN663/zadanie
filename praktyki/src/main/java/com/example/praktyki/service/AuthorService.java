package com.example.praktyki.service;

import com.example.praktyki.entity.Author;
import com.example.praktyki.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthorById(Long id){
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()) {
            return author.get();
        } else {
            return null;
        }
    }

    public void deleteById(long id){
        this.authorRepository.deleteById(id);
    }

    public void save(Author tmpBook){
        this.authorRepository.save(tmpBook);
    }
}