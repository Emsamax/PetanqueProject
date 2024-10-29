package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Data Transfer Object for Terrain.
 */
@Data
public class TerrainDTO {

    /**
     * The identifier for the petanque ground.
     */
    private Integer id;

    /**
     * The name of the petanque ground (100 characters max).
     * Cannot be null or blank.
     */
    @NotBlank
    private String nom;

    /**
     * The quantity of ???.
     * Cannot be null.
     * Should be greater than or equal to zero.
     */
    @NotNull
    @Min(value = 0)
    private Integer quantite;

    /**
     * A description of the petanque ground (100 characters max).
     */
    private String description;

    /**
     * The geographic point of the petanque ground (100 characters max).
     * Cannot be null or blank.
     */
    @NotBlank
    private String pointGeo;
}
