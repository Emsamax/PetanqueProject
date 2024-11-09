package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Key class for the Reservation entity.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ReservationId implements Serializable {
    /**
     * A foreign key reference to the Utilisateur table.
     */
    @ManyToOne
    @JoinColumn(name="utilisateur_id", referencedColumnName="id", nullable=false)
    private Utilisateur utilisateur;

    /**
     * A foreign key reference to the Terrain table.
     */
    @ManyToOne
    @JoinColumn(name="terrain_id", referencedColumnName="id", nullable=false)
    private Terrain terrain;
}
