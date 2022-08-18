package com.example.service;

import com.example.entity.Movie;
import com.example.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Movie saveMovie(Movie movie){
        return repository.save(movie);
    }

    public Optional<Movie> getMovieById(int id){
        return repository.findById(id);
    }

    public void deleteMovieById(int id){
         repository.deleteById(id);
    }

    public List<Movie> getAllMovies(){
        return repository.findAll();
    }
}
