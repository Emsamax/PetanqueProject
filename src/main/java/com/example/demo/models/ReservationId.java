package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents the composite key for the Reservation entity.
 * This class is embedded in the Reservation entity and consists of both
 * the utilisateur (user) ID and the terrain (petanque ground) ID.
 */
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Data
public class ReservationId {

    /**
     * The unique identifier for the user (utilisateur) associated with the reservation.
     * This field cannot be null and is part of the composite key for the reservation.
     */
    @Column(name = "utilisateur_id", nullable = false)
    @Schema(description = "The unique identifier for the user (utilisateur) associated with the reservation.")
    private Integer utilisateurId;

    /**
     * The unique identifier for the petanque ground (terrain) associated with the reservation.
     * This field cannot be null and is part of the composite key for the reservation.
     */
    @Column(name = "terrain_id", nullable = false)
    @Schema(description = "The unique identifier for the petanque ground (terrain) associated with the reservation.")
    private Integer terrainId;
}
