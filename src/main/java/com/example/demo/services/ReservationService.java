package com.example.demo.services;

import com.example.demo.mappers.TerrainMapper;
import com.example.demo.mappers.UtilisateurMapper;
import com.example.demo.models.Reservation;
import com.example.demo.dto.ReservationDTO;
import com.example.demo.mappers.ReservationIdMapper;
import com.example.demo.mappers.ReservationMapper;
import com.example.demo.models.ReservationId;
import com.example.demo.models.Terrain;
import com.example.demo.models.Utilisateur;
import com.example.demo.repositories.*;
import com.example.demo.utils.NotFoundException;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.StreamSupport;

/**
 * Service class responsible for business logic related to reservations.
 * Provides functionality for creating, retrieving, updating, and deleting reservations.
 */
@Service
@NoArgsConstructor
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private ReservationIdMapper reservationIdMapper;

    @Autowired
    private TerrainService terrainService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Autowired
    private TerrainMapper terrainMapper;

    /**
     * Retrieves a reservation by its ID.
     * If the reservation is not found, throws a NotFoundException.
     *
     * @param id the ID of the reservation to retrieve
     * @return the corresponding ReservationDTO
     * @throws NotFoundException if no reservation is found with the given ID
     */
    public ReservationDTO getReservationById(ReservationId id) throws NotFoundException {
        return reservationRepository.findById(id)
                .map(reservationMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Reservation with ID " + id + " not found"));
    }

    /**
     * Retrieves all reservations.
     *
     * @return an iterable collection of ReservationDTOs representing all reservations
     */
    public Iterable<ReservationDTO> getAllReservation() {
        return StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
                .map(reservationMapper::toDTO).toList();
    }

    /**
     * Creates a new reservation.
     * Validates the existence of the user and terrain, then decrements the terrain's quantity if valid.
     *
     * @param reservationDTO the ReservationDTO to save
     * @throws NotFoundException if the user, terrain or reservation is not found
     * @throws IllegalArgumentException if the reservation quantity exceeds available terrain quantity
     */
    @Transactional
    public void saveReservation(ReservationDTO reservationDTO) throws NotFoundException, IllegalArgumentException {
        // Check if the user exists
        if (!utilisateurService.existsById(reservationDTO.getId().getUtilisateurId())) {
            throw new NotFoundException("User with ID " + reservationDTO.getId().getUtilisateurId() + " not found");
        }

        // Check if the terrain exists
        if (!terrainService.existsById(reservationDTO.getId().getTerrainId())) {
            throw new NotFoundException("Terrain with ID " + reservationDTO.getId().getTerrainId() + " not found");
        }

        // Convert DTO to entity
        Reservation reservation = reservationMapper.toEntity(reservationDTO);

        // Retrieve the actual Utilisateur and Terrain entities
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurService.getUtilisateurById(reservation.getId().getUtilisateurId()));
        Terrain terrain = terrainMapper.toEntity(terrainService.getTerrainById(reservation.getId().getTerrainId()));

        // Set the actual entities in the Reservation object
        reservation.setUtilisateur(utilisateur);
        reservation.setTerrain(terrain);

        // Check if the reservation already exists
        if (reservationRepository.existsById(reservation.getId())) {
            throw new IllegalArgumentException("Reservation with ID " + reservation.getId() + " already exists");
        }

        // Decrement terrain quantity based on the reservation
        terrainService.decrementQuantite(reservationDTO.getId().getTerrainId(), reservationDTO.getReservation());

        // Save the reservation
        reservationRepository.save(reservation);
    }

    /**
     * Updates an existing reservation.
     * If the terrain quantity has changed, it updates the terrain's quantity accordingly.
     *
     * @param reservation the updated ReservationDTO
     * @throws NotFoundException if the reservation with the given ID is not found
     * @throws IllegalArgumentException if the updated reservation data is invalid
     */
    @Transactional
    public void updateReservation(ReservationDTO reservation) throws NotFoundException, IllegalArgumentException {
        // Convert the DTO reservation ID to the entity ID
        ReservationId reservationId = reservationIdMapper.toEntity(reservation.getId());
        Integer terrainId = reservation.getId().getTerrainId();
        Integer nbReservedTerrain = reservation.getReservation();

        // Retrieve the existing reservation from the database
        Reservation actualReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new NotFoundException("Reservation not found"));

        // Calculate the difference in quantity of terrain reserved
        int differenceQuantity = actualReservation.getReservation() - nbReservedTerrain;

        // Adjust terrain quantity based on the difference
        if (differenceQuantity >= 0) {
            terrainService.incrementQuantite(terrainId, differenceQuantity);
        } else {
            terrainService.decrementQuantite(terrainId, (-1) * differenceQuantity);
        }

        // Save the updated reservation
        reservationRepository.save(reservationMapper.toEntity(reservation));
    }

    /**
     * Deletes a reservation by ID.
     * After deletion, it increments the terrain quantity to reflect the cancellation of the reservation.
     *
     * @param id the ID of the reservation to delete
     * @throws NotFoundException if the reservation is not found
     */
    @Transactional
    public void deleteReservationById(ReservationId id) throws NotFoundException {
        // Find the reservation to be deleted
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reservation not found"));

        // Increment the terrain quantity to reflect the cancellation of the reservation
        terrainService.incrementQuantite(reservation.getId().getTerrainId(), reservation.getReservation());

        // Delete the reservation from the database
        reservationRepository.deleteById(id);
    }
}
