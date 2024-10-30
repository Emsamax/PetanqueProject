package com.example.demo.controllers;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.TerrainDTO;
import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.TerrainMapper;
import com.example.demo.UtilisateurMapper;
import com.example.demo.models.ReservationId;
import com.example.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Autowired
    private TerrainMapper terrainMapper;

    @PostMapping("/reservation")
    public ResponseEntity<Void> reserver(
            @RequestBody UtilisateurDTO utilisateurDTO,
            @RequestBody TerrainDTO terrainDTO) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(new ReservationId(utilisateurMapper.toEntity(utilisateurDTO), terrainMapper.toEntity(terrainDTO)));

        if (reservationService.save(reservationDTO)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<ReservationDTO>> getAllReservations() {
        Iterable<ReservationDTO> reservations = reservationService.readAll();
        return ResponseEntity.ok(reservations);
    }


    @GetMapping("/reservation/{id}")
    public ResponseEntity<Optional<ReservationDTO>> getReservationById(
            @PathVariable Integer reservationId) {

        Optional<ReservationDTO> reservation = reservationService.readById(reservationId);
        if (reservation.isPresent()) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/reservation/{id}")
    public ResponseEntity<Void> updateReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Integer id) {
        reservationService.update(id, reservationDTO);
        return ResponseEntity.ok().build();
    }

    // Endpoint pour supprimer une réservation par ID
    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable Integer id){
       reservationService.deleteById(id);
       return ResponseEntity.ok().build();
    }
}
