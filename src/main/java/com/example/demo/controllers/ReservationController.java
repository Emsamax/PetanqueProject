package com.example.demo.controllers;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.models.ReservationId;
import com.example.demo.services.ReservationService;
import com.example.demo.utils.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controller class for handling Reservation-related HTTP requests.
 * Provides endpoints for creating, retrieving, updating, and deleting reservations.
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * Retrieve a reservation by its ID.
     *
     * @param id the ID of the reservation to retrieve
     * @return ResponseEntity containing the ReservationDTO if found
     * @throws NotFoundException if no reservation with the specified ID is found
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get a reservation by ID", description = "Retrieve a reservation using its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved reservation"),
            @ApiResponse(responseCode = "404", description = "Reservation ID not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable ReservationId id) throws NotFoundException {
        ReservationDTO reservation = reservationService.getReservationById(id);
        return ResponseEntity.ok(reservation);
    }

    /**
     * Retrieve all reservations.
     *
     * @return an iterable list of all ReservationDTOs
     */
    @GetMapping
    @Operation(summary = "Get all reservations", description = "Retrieve a list of all reservations.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all reservations"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public Iterable<ReservationDTO> getAllReservation() {
        return reservationService.getAllReservation();
    }

    /**
     * Create a new reservation.
     *
     * @param reservation the ReservationDTO to be created
     * @return ResponseEntity with status code 200 if the reservation is created successfully
     * @throws NotFoundException if the referenced terrain or other required entities do not exist
     * @throws IllegalArgumentException if the reservation data is invalid
     */
    @PostMapping
    @Operation(summary = "Create a new reservation", description = "Create a new reservation by providing reservation data.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created reservation"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided in the body"),
            @ApiResponse(responseCode = "404", description = "Related entities not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> saveReservation(@RequestBody ReservationDTO reservation) throws NotFoundException, IllegalArgumentException {
        reservationService.saveReservation(reservation);
        return ResponseEntity.ok().build();
    }

    /**
     * Update an existing reservation by ID.
     *
     * @param id the ID of the reservation to be updated
     * @param reservation the updated reservation data
     * @return ResponseEntity with status code 200 if the reservation is updated successfully
     * @throws NotFoundException if the reservation with the given ID does not exist
     * @throws IllegalArgumentException if the provided data is invalid
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing reservation", description = "Update a reservation by providing the new data and reservation ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated reservation"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided in the body"),
            @ApiResponse(responseCode = "404", description = "Reservation ID not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> updateReservation(@PathVariable ReservationId id, @RequestBody ReservationDTO reservation) throws NotFoundException, IllegalArgumentException {
        reservationService.updateReservation(reservation);
        return ResponseEntity.ok().build();
    }

    /**
     * Delete a reservation by its ID.
     *
     * @param id the ID of the reservation to be deleted
     * @return ResponseEntity with status code 200 if the reservation is deleted successfully
     * @throws NotFoundException if the reservation with the given ID does not exist
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a reservation by ID", description = "Delete a reservation using its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted reservation"),
            @ApiResponse(responseCode = "404", description = "Reservation ID not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> deleteReservation(@PathVariable ReservationId id) throws NotFoundException {
        reservationService.deleteReservationById(id);
        return ResponseEntity.ok().build();
    }
}
