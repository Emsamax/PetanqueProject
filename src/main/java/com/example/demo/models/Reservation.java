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
}
