package com.example.cinema.entities.ticket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket create(Ticket ticket) {
        // Faltam validações...
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketsByMovieId(Long movieId) {
        return ticketRepository.findByMovieId(movieId);
    }
}
