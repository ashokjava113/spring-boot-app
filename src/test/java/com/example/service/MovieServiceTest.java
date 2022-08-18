package com.example.service;

import com.example.entity.Movie;
import com.example.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MovieService service;

//    AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
//        AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);
        this.service = new MovieService(this.repository);
    }

//    @AfterEach
//    void tearDown() {
//        try {
//            this.autoCloseable.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    void saveMovie() {
        Integer id = 12;
        String moviename = "Housefull";
        String actor = "Akshay Kumar";
        Movie movie = new Movie(id,moviename,actor);
        service.saveMovie(movie);
        verify(repository).save(movie);
    }

    @Test
    void getMovieById() {
        Integer id = 11;
        try {
            service.getMovieById(id);
        }catch (Exception e){
            System.out.println("Id should not be null");
        }
        verify(repository).findById(11);
    }

    @Test
    void deleteMovieById() {
        service.deleteMovieById(11);
        verify(repository).deleteById(11);
    }

    @Test
    void getAllMovies()
    {
        service.getAllMovies();
        verify(repository).findAll();
    }
}