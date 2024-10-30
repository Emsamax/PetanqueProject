package com.example.demo.controllers;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.models.ReservationId; // Import the ReservationId class
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Create a new reservation
    @PostMapping
    public ResponseEntity<Void> createReservation(@RequestBody ReservationDTO reservationDTO) {
        boolean created = reservationService.save(reservationDTO);
        if (created) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get a reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable ReservationId id) {
        Optional<ReservationDTO> reservationDTO = reservationService.readById(id);
        return reservationDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all reservations
    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservations = (List<ReservationDTO>) reservationService.readAll();
        return ResponseEntity.ok(reservations);
    }

    // Update a reservation by ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReservation(@PathVariable ReservationId id, @RequestBody ReservationDTO reservationDTO) {
        reservationService.update(id, reservationDTO);
        return ResponseEntity.ok().build();
    }

    // Delete a reservation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable ReservationId id) {
        reservationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
