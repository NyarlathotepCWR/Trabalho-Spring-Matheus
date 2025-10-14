package com.example.cinema.entities.ticket;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.example.cinema.entities.seat.SeatService;
import com.example.cinema.utils.ScheduledUtil;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final MovieService movieService;
    private final SeatService seatService;

    @Autowired
    public TicketController(TicketService ticketService, MovieService movieService, SeatService seatService) {
        this.ticketService = ticketService;
        this.movieService = movieService;
        this.seatService = seatService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequestDto ticketBody) {
        Ticket newTicket = new Ticket(ticketBody);
        Movie movie = movieService.findById(ticketBody.movieId());
        newTicket.setMovie(movie);

        ticketService.create(newTicket);

        // Aguarda 10 segundos para trocar o estado do assento
        ScheduledUtil scheduler = new ScheduledUtil();
        scheduler.scheduleFunction(() -> {
            seatService.toggleIsOccupied(ticketBody.seatId());
            scheduler.terminateExecutor();
        }, 10, TimeUnit.SECONDS);

        return ResponseEntity.ok(newTicket);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> ticketList = ticketService.findAll();
        return ResponseEntity.ok(ticketList);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<List<Ticket>> getTicketsByMovieId(@PathVariable Long movieId) {
        List<Ticket> ticketList = ticketService.getTicketsByMovieId(movieId);
        return ResponseEntity.ok(ticketList);
    }
}
