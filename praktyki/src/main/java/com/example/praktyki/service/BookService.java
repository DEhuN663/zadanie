package com.example.praktyki.service;

import com.example.praktyki.convert.BookDtoConverter;
import com.example.praktyki.entity.Book;
import com.example.praktyki.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.praktyki.dto.BookDto;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    BookDtoConverter bookDtoConverter;
    public BookDto getBook(BookDto bookDto) {
        // Tworzenie encji Book na podstawie wartości z BookDto
        Book book = bookDtoConverter.convertBookDtoToBook(bookDto);

        // Konwersja Book na BookDto i zwrócenie
        return bookDtoConverter.convertBookToBookDto(book);
    }
    public Book getBookById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    public void deleteById(long id){
        this.bookRepository.deleteById(id);
    }

    public void save(Book tmpBook){
        this.bookRepository.save(tmpBook);
    }
    }