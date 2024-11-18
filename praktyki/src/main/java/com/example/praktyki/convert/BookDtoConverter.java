package com.example.praktyki.convert;

import com.example.praktyki.dto.BookDto;
import com.example.praktyki.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BookDto convertBookToBookDto(Book book){
        BookDto bookDto = modelMapper.map(book, BookDto.class);

        return bookDto;
    }

    public Book convertBookDtoToBook(BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);

        return book;
    }
}
