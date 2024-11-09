package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Key class for the Reservation entity.
 */
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Data
public class ReservationId {

    @Column(name = "utilisateur_id")
    private Integer utilisateurId;

    @Column(name = "terrain_id")
    private Integer terrainId;
}
