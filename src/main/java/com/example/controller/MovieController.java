package com.example.controller;

import com.example.entity.Movie;
import com.example.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/movie")
    public Movie saveMovie(@Valid @RequestBody Movie movie) {
        Movie movie1 = null;
        try {
            movie1 = service.saveMovie(movie);
        } catch (Exception e) {
            System.out.println(e);
        }
        return movie1;
    }

    @GetMapping("/movie/{id}")
    public Optional<Movie> getMovieById(@Valid @PathVariable("id") int id) {
        return service.getMovieById(id);
//       Optional<Movie> movie = null;
//       try {
//           movie = service.getMovieById(id);
//       }catch (Exception e){
//           System.out.println("Data not found with id : "+id);
//       }
//       return movie;
    }

    @DeleteMapping("/movie/{id}")
    public String deleteMovieById(@Valid @PathVariable("id") int id) {
        try {
            service.deleteMovieById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "record deleted successfully";
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return service.getAllMovies();
    }

    @PatchMapping("/movie")
    public Movie updateMovie(@RequestBody Movie movie) {
        return service.saveMovie(movie);
    }
}
