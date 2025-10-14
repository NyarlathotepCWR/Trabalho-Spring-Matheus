package com.example.cinema.entities.session;

import com.example.cinema.entities.movie.Movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "time", nullable = false)
    private String time;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    public Session(SessionRequestDto sessionRequestDto) {
        this.date = sessionRequestDto.date();
        this.time = sessionRequestDto.time();
    }
}
