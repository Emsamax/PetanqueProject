package com.example.demo.mapper;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.models.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDTO toDTO(Reservation reservation);
    Reservation toEntity(ReservationDTO reservationDTO);
}
