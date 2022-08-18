package com.example.controller;

import com.example.entity.Movie;
import com.example.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {

    @Mock
    private MovieService service;

    @InjectMocks
    private MovieController controller;

    @BeforeEach
    void setUp() {
        this.controller = new MovieController(this.service);
    }

    @Test
    @Disabled
    void saveMovie() {
        Movie movie = new Movie();
        controller.saveMovie(movie);
        service.saveMovie(movie);
    }

    @Test
    void getMovieById() {
        controller.getMovieById(11);
        service.getMovieById(11);
    }

    @Test
    void deleteMovieById() {
        controller.deleteMovieById(11);
        service.deleteMovieById(11);
    }

    @Test
    void getAllMovies() {
        controller.getAllMovies();
        service.getAllMovies();
    }
}