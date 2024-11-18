package com.example.praktyki.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.praktyki.entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;
//    private long book_id;
    private String title;
    private int releaseDate;
    private String director;
    private String genre;
    private float price;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "book_id")
//    @JsonIgnoreProperties("movie")
    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JsonBackReference
    private Book book;

    public void setTitle(String title){
        this.title = title;
    }

    public void setReleaseDate(int releaseDate){
        this.releaseDate = releaseDate;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setPrice(Float price){
        this.price = price;
    }
}
