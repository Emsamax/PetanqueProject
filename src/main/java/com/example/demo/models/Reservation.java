package com.example.demo.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Represents a reservation in the system.
 * This class is mapped to the "reservation" table in the database.
 * A reservation is made for a specific user (utilisateur) and a specific petanque ground (terrain).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    /**
     * The embedded composite key for the reservation.
     * This key consists of both the user (utilisateur) and petanque ground (terrain) IDs.
     */
    @EmbeddedId
    @Schema(description = "The embedded composite key for the reservation, consisting of utilisateur and terrain IDs.")
    private ReservationId id;

    /**
     * The number of reserved terrain.
     */
    @Column(nullable = false)
    @NotNull(message = "The reservation code cannot be null.")
    @Schema(description = "The number of reserved terrain.")
    private Integer reservation;

    @ManyToOne
    @MapsId("utilisateurId")
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("terrainId")
    private Terrain terrain;
}
