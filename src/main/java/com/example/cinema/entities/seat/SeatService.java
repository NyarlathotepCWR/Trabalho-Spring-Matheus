package com.example.cinema.entities.seat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.infra.exceptions.NotFoundExceptions;

@Service
public class SeatService {
    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> findAll() {
        return seatRepository.findAll();
    }

    public Seat findById(Long id) {
        return seatRepository.findById(id).orElseThrow(() -> new NotFoundExceptions.SeatNotFound(id));
    }

    public void deleteById(Long id) {
        seatRepository.deleteById(id);
    }

    public List<Seat> findBySessionId(Long sessionId) {
        return seatRepository.findBySessionId(sessionId);
    }

    // Ocupa/desocupa o assento
    public Seat toggleIsOccupied(Long id) {
        Seat seatToUpdate = findById(id);
        seatToUpdate.setOccupied(!seatToUpdate.isOccupied());
        System.out.println("ASSENTO INVERTIDO: " + seatToUpdate.isOccupied());
        return save(seatToUpdate);
    }
}
