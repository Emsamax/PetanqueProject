package com.example.demo.mappers;

import com.example.demo.dto.ReservationIdDTO;
import com.example.demo.models.ReservationId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationIdMapper {
    ReservationIdDTO toDTO(ReservationId reservation);

    ReservationId toEntity(ReservationIdDTO reservationDTO);
}

