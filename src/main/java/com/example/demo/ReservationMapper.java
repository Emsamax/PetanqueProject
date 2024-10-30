package com.example.demo;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.models.Reservation;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;


@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDTO toDTO(Reservation reservation);
    Reservation toEntity(ReservationDTO reservationDTO);
}
