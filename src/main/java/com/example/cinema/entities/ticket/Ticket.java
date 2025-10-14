package com.example.cinema.entities.ticket;

import com.example.cinema.entities.movie.Movie;
import com.example.cinema.entities.seat.Seat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false, precision = 2)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;

    public Ticket(TicketRequestDto data) {
        this.price = data.price();
    }
}
