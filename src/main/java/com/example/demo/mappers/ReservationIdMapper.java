package com.example.demo.mappers;

import com.example.demo.dto.ReservationIdDTO;
import com.example.demo.models.ReservationId;

import org.mapstruct.Mapper;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Mapper interface for converting between the ReservationId entity and its corresponding DTO (ReservationIdDTO).
 * This interface uses MapStruct to automate the mapping process between the entity and DTO.
 */
@Mapper(componentModel = "spring")
public interface ReservationIdMapper {

    /**
     * Converts a ReservationId entity to its corresponding ReservationIdDTO.
     *
     * @param reservation the ReservationId entity to be converted
     * @return the corresponding ReservationIdDTO
     */
    @Schema(description = "Converts a ReservationId entity to its corresponding ReservationIdDTO.")
    ReservationIdDTO toDTO(ReservationId reservation);

    /**
     * Converts a ReservationIdDTO to its corresponding ReservationId entity.
     *
     * @param reservationDTO the ReservationIdDTO to be converted
     * @return the corresponding ReservationId entity
     */
    @Schema(description = "Converts a ReservationIdDTO to its corresponding ReservationId entity.")
    ReservationId toEntity(ReservationIdDTO reservationDTO);
}
