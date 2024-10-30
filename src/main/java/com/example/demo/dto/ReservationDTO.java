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

    /**
     * The reservation value.
     * Cannot be null.
     */
    @NotNull(message = "Reservation cannot be null")
    private Integer reservation;
}
