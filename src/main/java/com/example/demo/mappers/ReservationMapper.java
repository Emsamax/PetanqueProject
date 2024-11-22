package com.example.demo.mappers;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.models.Reservation;

import org.mapstruct.Mapper;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Mapper interface for converting between the Reservation entity and its corresponding DTO (ReservationDTO).
 * This interface uses MapStruct to automate the mapping process between the entity and DTO.
 */
@Mapper(componentModel = "spring")
public interface ReservationMapper {

    /**
     * Converts a Reservation entity to its corresponding ReservationDTO.
     *
     * @param reservation the Reservation entity to be converted
     * @return the corresponding ReservationDTO
     */
    @Schema(description = "Converts a Reservation entity to its corresponding ReservationDTO.")
    ReservationDTO toDTO(Reservation reservation);

    /**
     * Converts a ReservationDTO to its corresponding Reservation entity.
     *
     * @param reservationDTO the ReservationDTO to be converted
     * @return the corresponding Reservation entity
     */
    @Schema(description = "Converts a ReservationDTO to its corresponding Reservation entity.")
    Reservation toEntity(ReservationDTO reservationDTO);
}
