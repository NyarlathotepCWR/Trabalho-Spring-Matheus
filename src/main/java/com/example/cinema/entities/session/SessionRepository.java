package com.example.cinema.entities.session;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByMovieId(Long movieId);
}
