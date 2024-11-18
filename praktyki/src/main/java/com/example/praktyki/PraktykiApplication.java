package com.example.praktyki;

import com.example.praktyki.controller.BookController;
import com.example.praktyki.controller.MovieController;
import com.example.praktyki.entity.Movie;
import com.example.praktyki.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PraktykiApplication {

	@Autowired
	MovieController movieController;

	@Autowired
	BookController bookController;
	public static void main(String[] args) {
		SpringApplication.run(PraktykiApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		movieController.insert();
//
//		Movie tmpMovie = movieController.getById(1l);
//		System.out.println(tmpMovie);
//
//		if(movieController.getById(1l) != null){
//			tmpMovie = movieController.getById(1l);
//			tmpMovie.setTitle("Movie Movie");
//			movieController.save(tmpMovie);
//		}
//
////		movieController.deleteById(1L);
//	}
}
