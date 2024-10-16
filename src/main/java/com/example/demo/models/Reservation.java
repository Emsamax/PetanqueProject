package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull; // use javax.validation.constraints.NotNull

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
@Entity
@Table(name = "reservation")
public class Reservation {
    /**
     * The user associated with this reservation.
     * Cannot be null.
     * A foreign key reference to the Utilisateur table.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Utilisateur utilisateur;

    /**
     * The terrain associated with this reservation.
     * Cannot be null.
     * A foreign key reference to the Terrain table.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "terrain_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Terrain terrain;

    /**
     * The ????.
     * Cannot be null.
     */
    @Column(nullable = false)
    @NotNull
    private Integer reservation;
}
