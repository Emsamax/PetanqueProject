package com.example.demo.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) for the composite key used in Reservation.
 * This class is used to transfer the composite key data (user ID and petanque ground ID) for a reservation.
 * It includes the IDs of the user and the petanque ground involved in the reservation.
 */
@Data
@AllArgsConstructor
public class ReservationIdDTO implements Serializable {

    /**
     * The identifier for the user associated with the reservation.
     * Cannot be null.
     */
    @Schema(description = "The user ID associated with the reservation (cannot be null).")
    private Integer utilisateurId;

    /**
     * The identifier for the petanque ground associated with the reservation.
     * Cannot be null.
     */
    @Schema(description = "The petanque ground ID associated with the reservation (cannot be null).")
    private Integer terrainId;
}
