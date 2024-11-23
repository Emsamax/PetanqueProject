package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Data Transfer Object (DTO) for the Reservation entity.
 * This class is used to transfer data about a reservation between layers (e.g., between controllers and services).
 * It includes information such as the composite key for the reservation and the reservation details.
 */
@Data
@AllArgsConstructor
public class ReservationDTO {

    /**
     * The embedded composite key for the reservation.
     * This field represents the unique combination of the user ID and petanque ground ID for the reservation.
     * It cannot be null.
     */
    @NotNull(message = "The reservation ID cannot be null.")
    @Schema(description = "The composite key for the reservation (includes user and petanque ground IDs).")
    private ReservationIdDTO id;

    /**
     * The number of reserved terrain.
     */
    @Schema(description = "The number of reserved terrain.")
    private Integer reservation;
}
