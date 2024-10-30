package com.example.demo.services;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.mappers.ReservationMapper;
import com.example.demo.models.ReservationId; // Importer ReservationId
import com.example.demo.repositories.ReservationRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Changez le type de id en ReservationId
    public Optional<ReservationDTO> readById(ReservationId id) {
        return reservationRepository.findById(id).map(reservationMapper::toDTO);
    }

    public Iterable<ReservationDTO> readAll() {
        return StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(ReservationId id) {
        reservationRepository.deleteById(id);
    }

    /**
     * Check first if exist
     * yes -> delete then create
     * no -> create
     * @param reservationDTO
     */
    public void update(ReservationId id, ReservationDTO reservationDTO) {
        if (reservationRepository.findById(id).isPresent()) {
            deleteById(id);
            reservationRepository.save(reservationMapper.toEntity(reservationDTO));
        } else {
            reservationRepository.save(reservationMapper.toEntity(reservationDTO));
        }
    }

    public boolean save(ReservationDTO reservationDTO) {
        if (reservationDTO.getId() == null) {
            reservationRepository.save(reservationMapper.toEntity(reservationDTO));
            return true;
        }
        return false;
    }
}
