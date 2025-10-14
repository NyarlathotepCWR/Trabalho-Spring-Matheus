package com.example.cinema.entities.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
public class Movie {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "runtime", nullable = false)
    private Integer runtime;

    public Movie(MovieDto data) {
        this.id = data.id();
        this.name = data.name();
        this.runtime = data.runtime();
    }
}
