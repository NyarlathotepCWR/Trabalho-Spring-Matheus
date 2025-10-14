package com.example.cinema.entities.ticket;

public record TicketRequestDto(Long movieId, Double price, Long seatId) {
}
