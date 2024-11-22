package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

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
     * The unique reservation identifier (or code).
     * This field cannot be null and is typically used to uniquely identify a reservation.
     */
    @Column(nullable = false)
    @NotNull(message = "The reservation code cannot be null.")
    @Schema(description = "The unique identifier for the reservation (cannot be null).")
    private Integer reservation;

    /**
     * The utilisateur (user) associated with this reservation.
     * This field is required and links the reservation to a specific user.
     */
    @ManyToOne
    @MapsId("utilisateurId")
    @JoinColumn(name = "utilisateur_id", nullable = false)
    @NotNull(message = "The utilisateur (user) cannot be null.")
    @Schema(description = "The user associated with the reservation.")
    private Utilisateur utilisateur;

    /**
     * The terrain (petanque ground) associated with this reservation.
     * This field is required and links the reservation to a specific petanque ground.
     */
    @ManyToOne
    @MapsId("terrainId")
    @JoinColumn(name = "terrain_id", nullable = false)
    @NotNull(message = "The terrain (petanque ground) cannot be null.")
    @Schema(description = "The petanque ground associated with the reservation.")
    private Terrain terrain;
}
