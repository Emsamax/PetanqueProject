package com.example.demo.controllers;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.TerrainDTO;
import com.example.demo.dto.UtilisateurDTO;
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

    // Get a reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable ReservationId id) throws Exception {
        Optional<ReservationDTO> reservationDTO = reservationService.getReservationById(id);
        ReservationDTO reservation = reservationDTO.get();
        return ResponseEntity.ok(reservation);
    }

    // Get all reservations
    @GetMapping
    public Iterable<ReservationDTO> getAllReservation() throws Exception {
        return reservationService.getAllReservation();
    }

    // Create a new reservation
    @PostMapping
    public ResponseEntity<Void> saveReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.saveReservation(reservationDTO);
        return ResponseEntity.ok().build();
    }

    // Update a reservation by ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReservation(@PathVariable ReservationId id, @RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.notFound().build();
    }

    // Delete a reservation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable ReservationId id) {
        return ResponseEntity.notFound().build();
    }
}
