package com.example.demo.services;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.dto.TerrainDTO;
import com.example.demo.mappers.ReservationIdMapper;
import com.example.demo.mappers.ReservationMapper;
import com.example.demo.models.ReservationId; // Importer ReservationId
import com.example.demo.repositories.ReservationRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@NoArgsConstructor
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationMapper reservationMapper;
    private ReservationIdMapper reservationIdMapper;

    // Changez le type de id en ReservationId
    public Optional<ReservationDTO> getReservationById(ReservationId id) throws ChangeSetPersister.NotFoundException {
        return Optional.ofNullable(reservationRepository.findById(id)
                .map(reservationMapper::toDTO)
                .orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public Iterable<ReservationDTO> getAllReservation() {
        return StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
                .map(reservationMapper::toDTO).toList();
    }

    public void saveReservation(ReservationDTO reservationDTO) {
        reservationRepository.save(reservationMapper.toEntity(reservationDTO));
    }

    /**
     * Check first if exist
     * yes -> delete then create
     * no -> create
     * @param reservationDTO
     */
    public void updateReservation(ReservationDTO reservationDTO) throws ChangeSetPersister.NotFoundException {
        // Vérifie si le terrain existe avant de procéder à la mise à jour
        if (!reservationRepository.existsById(reservationIdMapper.toEntity(reservationDTO.getId()))) {
            throw new ChangeSetPersister.NotFoundException();
        }



        // Sauvegarde le terrain mis à jour
        reservationRepository.save(reservationMapper.toEntity(reservationDTO));
    }

    public void deleteReservationById(ReservationId id) throws ChangeSetPersister.NotFoundException {
        // Vérifie si le terrain existe avant de le supprimer
        if (!reservationRepository.existsById(id)) {
            throw new ChangeSetPersister.NotFoundException();
        }
        reservationRepository.deleteById(id);
    }
}
