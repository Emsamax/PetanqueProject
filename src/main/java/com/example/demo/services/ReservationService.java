package com.example.demo.services;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.mappers.ReservationIdMapper;
import com.example.demo.mappers.ReservationMapper;
import com.example.demo.models.ReservationId;
import com.example.demo.repositories.*;
import com.example.demo.utils.NotFoundException;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
@NoArgsConstructor
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    private TerrainRepository terrainRepository;
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ReservationMapper reservationMapper;
    private ReservationIdMapper reservationIdMapper;

    @Autowired
    private TerrainService terrainService;

    public ReservationDTO getReservationById(ReservationId id) throws NotFoundException {
        return reservationRepository.findById(id)
                .map(reservationMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Reservation with ID " + id + " not found"));
    }

    public Iterable<ReservationDTO> getAllReservation() {
        return StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
                .map(reservationMapper::toDTO).toList();
    }

    public void saveReservation(ReservationDTO reservation) throws NotFoundException, IllegalArgumentException {
        if (!utilisateurRepository.existsById(reservation.getId().getUtilisateurId())) {
            throw new NotFoundException("User with ID " + reservation.getId().getUtilisateurId() + " not found");
        }

        if (!terrainRepository.existsById(reservation.getId().getTerrainId())) {
            throw new NotFoundException("Terrain with ID " + reservation.getId().getTerrainId() + " not found");
        }

        // throws excpetion if terrain id not found or reservation.getReservation() is higher that terrain quantite
        terrainService.decrementQuantite(reservation.getId().getTerrainId(), reservation.getReservation());

        reservationRepository.save(reservationMapper.toEntity(reservation));
    }

    /**
     * @param reservationDTO
     */
    public void updateReservation(ReservationDTO reservation) throws NotFoundException {
        // Vérifie si le terrain existe avant de procéder à la mise à jour
        if (!reservationRepository.existsById(reservationIdMapper.toEntity(reservation.getId()))) {
            throw new NotFoundException("Reservation not found");
        }



        // Sauvegarde le terrain mis à jour
        reservationRepository.save(reservationMapper.toEntity(reservation));
    }

    public void deleteReservationById(ReservationId id) throws ChangeSetPersister.NotFoundException {
        // Vérifie si le terrain existe avant de le supprimer
        if (!reservationRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }
        reservationRepository.deleteById(id);
    }
}
