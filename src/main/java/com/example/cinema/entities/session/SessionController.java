package com.example.cinema.entities.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.entities.movie.Movie;
import com.example.cinema.entities.movie.MovieService;

@RestController
@RequestMapping("/session")
public class SessionController {
    private final SessionService sessionService;
    private final MovieService movieService;

    @Autowired
    public SessionController(SessionService sessionService, MovieService movieService) {
        this.sessionService = sessionService;
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAllSessions() {
        List<Session> sessionList = sessionService.findAll();
        return ResponseEntity.ok(sessionList);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Session>> getSessionsByMovie(@PathVariable Long movieId) {
        List<Session> sessionList = sessionService.getSessionsByMovie(movieId);
        return ResponseEntity.ok(sessionList);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long sessionId) {
        Session session = sessionService.getSessionById(sessionId);
        return ResponseEntity.ok(session);
    }

    @PostMapping
    public ResponseEntity<Session> createSession(@RequestBody SessionRequestDto sessionBody) {
        Session newSession = new Session(sessionBody);
        Movie movie = movieService.findById(sessionBody.movieId());
        newSession.setMovie(movie);
        
        sessionService.createSession(newSession);
        return ResponseEntity.ok(newSession);
    }
}
