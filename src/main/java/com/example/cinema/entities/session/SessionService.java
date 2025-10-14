package com.example.cinema.entities.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.infra.exceptions.NotFoundExceptions;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public Session getSessionById(Long id) {
        return sessionRepository.findById(id).orElseThrow(() -> new NotFoundExceptions.SessionNotFound(id));
    }

    public List<Session> getSessionsByMovie(Long movieId) {
        return sessionRepository.findByMovieId(movieId);
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }
}
