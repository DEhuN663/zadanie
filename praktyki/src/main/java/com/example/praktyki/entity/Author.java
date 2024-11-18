package com.example.praktyki.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private long id;
    private String name;
    private String surname;


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
//    private List<Movie> movie;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "author_id")
    @JsonBackReference
    private Book book;

//    public void setId(long id){
//        this.id = id;
//    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

}
