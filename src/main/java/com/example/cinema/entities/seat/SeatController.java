package com.example.cinema.entities.seat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {
    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seatList = seatService.findAll();
        return ResponseEntity.ok(seatList);
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<Seat>> getSeatsBySession(@PathVariable Long sessionId) {
        List<Seat> seatList = seatService.findBySessionId(sessionId);
        return ResponseEntity.ok(seatList);
    }
}
