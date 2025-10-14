package com.example.cinema.entities.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody MovieDto movieBody) {
        Movie newMovie = new Movie(movieBody);
        movieService.create(newMovie);

        return ResponseEntity.ok(newMovie);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movieList = movieService.findAll();

        return ResponseEntity.ok(movieList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.findById(id);

        return ResponseEntity.ok(movie);
    }
}
