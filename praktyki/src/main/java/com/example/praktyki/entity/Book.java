package com.example.praktyki.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.praktyki.entity.Movie;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long id;
    private String title;
    private int releaseDate;
    private float price;

//    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
//    @JsonIgnoreProperties("book")
    @OneToMany(targetEntity = Movie.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "book_id")
    @JsonManagedReference
    private List<Movie> movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonManagedReference
    private Author author_id;

//    public void setId(long id){
//        this.id = id;
//    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setReleaseDate(int releaseDate){
        this.releaseDate = releaseDate;
    }

    public void setPrice(Float price){
        this.price = price;
    }
}
