package com.example.repository;

import com.example.entity.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;

    @Test
    void isMovieExistsById() {
        Movie movie = new Movie(11,"Housefull","Akshay kumar");
        repository.save(movie);

        Boolean actualResult = repository.isMovieExistsById(11);
        assertThat(actualResult).isTrue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing Down");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Setting Up");
    }
}