package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;

/*
 * TO DO :
 * - What is "reservation" ?????????????????????
 */

/**
 * Represents a reservation in the system.
 * This class is mapped to the "reservation" table in the database.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    /**
     * Embedded composite key for the reservation.
     */
    @EmbeddedId
    private ReservationId id;

    /**
     * The ????.
     * Cannot be null.
     */
    @Column(nullable = false)
    @NotNull
    private Integer reservation;

    @ManyToOne
    @MapsId("utilisateurId")
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("terrainId")
    @JoinColumn(name = "terrain_id")
    private Terrain terrain;
}
