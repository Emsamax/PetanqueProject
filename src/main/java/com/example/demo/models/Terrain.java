package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

/*
 * TO DO :
 * - Add security quantité ( >= 0 )
 * - What is quantite ??????????
 */

/**
 * Represents the petanque ground in the system.
 * This class is mapped to the "terrain" table in the database.
 */
@Entity
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "terrain")
public class Terrain {
    /**
     * The identifier for the petanque ground.
     * Is unique.
     * Automatically generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The name of the petanque ground (100 characters max).
     * Cannot be null.
     */
    @Column(name="nom", nullable = false, length = 100)
    @NotBlank
    private String nom;

    /**
     * The quantity of ???.
     * Cannot be null.
     * Should be greater or equal to zero.
     */
    @Column(name="quantite", nullable = false)
    @Min(value = 0)
    @NotNull
    private Integer quantite;

    /**
     * A description of the petanque ground (100 characters max).
     */
    @Column(name="description", length = 100)
    private String description;

    /**
     * The geographic point of the petanque ground (100 characters max).
     * Cannot be null.
     */
    @Column(name="point_geo", nullable = false, length = 100)
    @NotBlank
    private String pointGeo;

    @OneToMany(mappedBy = "terrain")
    private List<Reservation> reservations;
}
