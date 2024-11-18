package com.example.praktyki.service;

import com.example.praktyki.entity.Movie;
import com.example.praktyki.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(Long id){
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()) {
            return movie.get();
        } else {
            return null;
        }
    }

    public void deleteById(long id){
        this.movieRepository.deleteById(id);
    }

    public void save(Movie tmpMovie){
        this.movieRepository.save(tmpMovie);
    }

//    public void insert(String title, String director, String genre, int releaseDate, float price){
//        Movie tmpMovie = new Movie();
//        tmpMovie.setTitle(title);
//        tmpMovie.setDirector(director);
//        tmpMovie.setGenre(genre);
//        tmpMovie.setReleaseDate(releaseDate);
//        tmpMovie.setPrice(price);
//        this.movieRepository.save(tmpMovie);
//    }
//
//    public void insert(Long id, String title, String director, String genre, int releaseDate, float price){
//        Movie tmpMovie = new Movie();
//        tmpMovie.setId(id);
//        tmpMovie.setTitle(title);
//        tmpMovie.setDirector(director);
//        tmpMovie.setGenre(genre);
//        tmpMovie.setReleaseDate(releaseDate);
//        tmpMovie.setPrice(price);
//        this.movieRepository.save(tmpMovie);
//    }


}
