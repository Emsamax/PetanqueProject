package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Data Transfer Object for Reservation.
 */
@Data
public class ReservationDTO {

    /**
     * Embedded composite key for the reservation.
     */
    private ReservationIdDTO id;

    private Integer reservation;
}
